package com.ada.user.dao.impl;

import java.util.List;

import com.quhaodian.data.rest.domain.AbstractVo;
import com.ada.user.security.SecurityUtil;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.CriteriaDaoImpl;
import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.ada.user.dao.UserInfoDao;
import com.ada.user.entity.UserInfo;
import com.ada.user.vo.UserStateVo;
import com.young.security.Digests;
import com.young.security.Encodes;

@Repository
public class UserInfoDaoImpl extends CriteriaDaoImpl<UserInfo, Long> implements UserInfoDao {
    public Pagination getPage(int pageNo, int pageSize) {
        Criteria crit = createCriteria();
        Pagination page = findByCriteria(crit, pageNo, pageSize);
        return page;
    }

    public UserStateVo reg(UserInfo user) {
        UserStateVo result = new UserStateVo();
        if (user == null || user.getUsername() == null) {
            result.setCode(-2);
            result.setMessage("用户名不能为空");
            return result;
        }
        if (user.getUsername().length() < 2) {
            result.setCode(-3);
            result.setMessage("用户名长度过短");
            return result;
        }
        if (user.getPlainPassword() == null) {
            result.setCode(-4);
            result.setMessage("密码不存在");
            return result;
        }
        UserInfo tempuser = null;
        Finder finder = Finder.create();
        finder.append("from UserInfo u where u.username ='" + user.getUsername() + "'");
        // finder.append(" and u.password = '" + password + "'");
        List<UserInfo> us = find(finder);
        if (us != null && us.size() > 0) {
            tempuser = new UserInfo();
            tempuser.setId(-1l);
            result.setCode(-1);
            result.setMessage("该用户名已被使用");
        } else {

            entryptPassword(user);

            tempuser = save(user);
            result.setUser(tempuser);
        }
        return result;
    }

    public UserInfo findById(Long id) {
        UserInfo entity = get(id);
        return entity;
    }

    public UserInfo save(UserInfo bean) {
        getSession().save(bean);
        return bean;
    }

    public UserInfo deleteById(Long id) {
        UserInfo entity = super.get(id);
        if (entity != null) {
            getSession().delete(entity);
        }
        return entity;
    }

    @Override
    protected Class<UserInfo> getEntityClass() {
        return UserInfo.class;
    }

    @Autowired
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    /**
     * 验证原密码是否正确
     *
     * @param user
     * @param oldPassword
     * @return
     */
    public boolean checkPassword(UserInfo user, String oldPassword) {
        byte[] salt = Encodes.decodeHex(user.getSalt());
        byte[] hashPassword = Digests.sha1(oldPassword.getBytes(), salt, HASH_INTERATIONS);
        return user.getPassword().equals(Encodes.encodeHex(hashPassword));
    }

    /**
     * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
     */
    private void entryptPassword(UserInfo user) {
        byte[] salt = Digests.generateSalt(SALT_SIZE);
        user.setSalt(Encodes.encodeHex(salt));

        byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(), salt, HASH_INTERATIONS);
        user.setPassword(Encodes.encodeHex(hashPassword));
    }

    @Override
    public UserInfo register(String username, String password, String email) {
        UserInfo result = new UserInfo();
        Finder finder = Finder.create();
        finder.append("from UserInfo u where u.username ='" + username + "'");
        // finder.append(" and u.password = '" + password + "'");
        List<UserInfo> us = find(finder);
        if (us != null && us.size() > 0) {
            result.setId(-1l);
        } else {
            UserInfo bean = new UserInfo();
            bean.setUsername(username);
            bean.setPlainPassword(password);
            entryptPassword(bean);
            result = save(bean);
        }
        return result;
    }

    public AbstractVo modifyPassword(Long user, String oldPassword, String newPassword) {
        AbstractVo result = new AbstractVo();
        if (user == null) {
            result.setCode(-1);
            result.setMsg("该用户不存在");
            return result;
        }
        UserInfo userInfo = findById(user);
        SecurityUtil securityUtil = new SecurityUtil(userInfo.getSalt());
        if (securityUtil.checkPassword(userInfo.getPassword(), oldPassword)) {
            SecurityUtil temp = new SecurityUtil();
            userInfo.setSalt(temp.getSalt());
            userInfo.setPassword(temp.entryptPassword(newPassword));
        } else {
            result.setCode(-2);
            result.setMsg("老密码不正确");
            return result;
        }
        return result;
    }

    @Override
    public UserInfo findByName(String name) {
        Finder finder = Finder.create();
        finder.append("from UserInfo u where u.username ='" + name + "'");
        // finder.append(" and u.password = '" + password + "'");
        return findOne(finder);
    }

}