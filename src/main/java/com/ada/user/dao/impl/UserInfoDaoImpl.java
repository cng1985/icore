package com.ada.user.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.BaseDaoImpl;
import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.user.dao.UserInfoDao;
import com.ada.user.entity.UserInfo;
import com.young.security.Digests;
import com.young.security.Encodes;

@Repository
public class UserInfoDaoImpl extends BaseDaoImpl<UserInfo, Long> implements UserInfoDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
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
	 * @param oldPwd
	 * @return
	 */
	public boolean checkPassword(UserInfo user, String oldPassword) {
		byte[] salt = Encodes.decodeHex(user.getSalt());
		byte[] hashPassword = Digests.sha1(oldPassword.getBytes(), salt, HASH_INTERATIONS);
		if (user.getPassword().equals(Encodes.encodeHex(hashPassword))) {
			return true;
		} else {
			return false;
		}
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
	public UserInfo register( String username, String password,String email) {
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
			bean.setEmail(email);
			entryptPassword(bean);
			result=save(bean);
		}
		return result;
	}

}