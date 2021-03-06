package com.ada.user.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import com.ada.user.dao.UserInfoDao;
import com.ada.user.entity.UserInfo;
import com.ada.user.entity.UserRole;
import com.ada.user.service.UserInfoService;
import com.young.security.Digests;
import com.young.security.Encodes;

@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {



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

	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public UserInfo findById(Long id) {
		UserInfo entity = dao.findById(id);
		Set<UserRole> roles = entity.getRoles();
		if (roles != null) {
			for (UserRole userRole : roles) {

			}
		}
		return entity;
	}

	@Transactional
	public UserInfo save(UserInfo bean) {
		dao.save(bean);
		return bean;
	}

	@Transactional
	public UserInfo update(UserInfo bean) {
		Updater<UserInfo> updater = new Updater<UserInfo>(bean);
		if (bean.getPlainPassword() != null && bean.getPlainPassword().length() > 5) {
			entryptPassword(bean);
		}
		updater.exclude("attributes");
		updater.exclude("roles");
		updater.exclude("catalog");
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public UserInfo deleteById(Long id) {
		UserInfo bean = dao.deleteById(id);
		dao.deleteById(id);
		return bean;
	}

	@Transactional
	public UserInfo[] deleteByIds(Long[] ids) {
		UserInfo[] beans = new UserInfo[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserInfoDao dao;

	@Autowired
	public void setDao(UserInfoDao dao) {
		this.dao = dao;
	}

	@Transactional
	@Override
	public UserInfo login(String username, String password, String macaddress) {
		UserInfo result = null;
		Finder finder = Finder.create();
		finder.append("from UserInfo u where u.username ='" + username + "'");
		// finder.append(" and u.password = '" + password + "'");
		List<UserInfo> us = dao.find(finder);
		if (us != null && us.size() > 0) {
			result = us.get(0);
			if (checkPassword(result, password)) {
				result.setLastDate(new Date());
				Integer logintime = result.getLoginSize();
				if (logintime == null) {
					logintime = 0;
				}
				logintime++;
				result.setLoginSize(logintime);
			} else {
				result = new UserInfo();
				result.setId(-1l);
			}

		} else {
			result = new UserInfo();
			result.setId(-2l);
		}
		return result;
	}

	@Transactional
	@Override
	public int register(String email, String username, String password) {
		int result = 0;
		Finder finder = Finder.create();
		finder.append("from UserInfo u where u.username ='" + username + "'");
		// finder.append(" and u.password = '" + password + "'");
		List<UserInfo> us = dao.find(finder);
		if (us != null && us.size() > 0) {
			result = -1;
		} else {
			UserInfo bean = new UserInfo();
			bean.setUsername(username);
			bean.setPlainPassword(password);
			entryptPassword(bean);
			dao.save(bean);
			result = 1;
		}
		return result;
	}

	@Override
	public UserInfo findByUsername(String username) {
		UserInfo result = null;
		Finder finder = Finder.create();
		finder.append("from UserInfo u where u.username ='" + username + "'");
		List<UserInfo> us = dao.find(finder);
		if (us != null && us.size() > 0) {
			result = us.get(0);
		}
		return result;
	}

	/**
	 * 修改用户登录
	 * 
	 * @param user
	 */
	@Transactional
	public UserInfo updateUserLogin(UserInfo user) {
		user = dao.findById(user.getId());
		user.setLastDate(new Date());
		Integer times = user.getLoginSize();
		if (times == null) {
			times = 0;
		}
		times++;
		user.setLoginSize(times);
		return update(user);
	}

	@Transactional
	@Override
	public UserInfo reg(String email, String username, String password) {
		UserInfo result = null;
		Finder finder = Finder.create();
		finder.append("from UserInfo u where u.username ='" + username + "'");
		// finder.append(" and u.password = '" + password + "'");
		List<UserInfo> us = dao.find(finder);
		if (us != null && us.size() > 0) {
			result = new UserInfo();
			result.setId(-1l);
		} else {
			UserInfo bean = new UserInfo();
			bean.setUsername(username);
			bean.setPlainPassword(password);
			entryptPassword(bean);
			result = dao.save(bean);
		}
		return result;
	}

	@Transactional(readOnly = true)
	@Override
	public Pagination pageByRole(long roleid, int pageNo, int pageSize) {
		Finder finder = Finder.create();
		finder.append("select u from UserInfo u join u.roles as r  where r.id=:roleid");
		finder.setParam("roleid", roleid);
		finder.append(" order by u.id desc ");
		Pagination page = dao.find(finder, pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	@Override
	public Pagination pageByFollower(long userid, int pageNo, int pageSize) {
		Finder finder = Finder.create();
		finder.append("select u.follower from UserFollow u where u.userInfo.id=:userid");
		finder.setParam("userid", userid);
		finder.append(" order by u.id desc ");
		Pagination page = dao.find(finder, pageNo, pageSize);
		return page;
	}

	@Transactional
	@Override
	public UserInfo addRole(long id, UserRole bean) {
		UserInfo entity = dao.findById(id);
		entity.getRoles().add(bean);
		return entity;
	}

	@Transactional
	@Override
	public UserInfo reg(UserInfo user) {
		return dao.reg(user).getUser();
	}

	@Transactional
	@Override
	public UserInfo addRole(long id, long roleid) {
		UserInfo entity = dao.findById(id);
		if (entity != null) {
			UserRole bean = new UserRole();
			bean.setId(roleid);
			entity.getRoles().add(bean);
		}

		return entity;
	}

	@Transactional
	@Override
	public UserInfo update(String username, String phone, String email) {
		UserInfo result = null;
		Finder finder = Finder.create("from UserInfo u where u.username =:username ");
		finder.setParam("username", username);
		finder.append(" and u.phone =:phone");
		finder.setParam("phone", phone);
		List<UserInfo> users = dao.find(finder);
		if (users != null && users.size() > 0) {
			result = users.get(0);
		} else {
			result = new UserInfo();
			result.setUsername(username);
			result.setPlainPassword("123456");
			entryptPassword(result);
			result = save(result);
		}

		return result;
	}

	@Transactional(readOnly = true)
	public List<String> findAuthorities(Long id) {
		List<String> authorities = new ArrayList<String>();
		UserInfo admin = dao.findById(id);
		if (admin != null) {
			for (UserRole role : admin.getRoles()) {
				authorities.addAll(role.getAuthorities());
			}
		}
		return authorities;
	}

	@Override
	public Page<UserInfo> findPage(Pageable pageable) {
		return dao.findPage(pageable);
	}

    @Override
    public Page<UserInfo> page(Pageable pageable) {
        return dao.page(pageable);
    }

    @Override
	public long count(Filter... filters) {
		return dao.count(filters);
	}

	@Override
	public List<UserInfo> list(Integer first, Integer count, List<Filter> filters, List<Order> orders) {
		return dao.list(first, count, filters, orders);
	}

	@Override
	public List<UserInfo> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders) {
		return dao.findList(first, count, filters, orders);
	}

	@Transactional
	@Override
	public UserInfo loginqq(String openid, String nickname, String figureurl_qq_1) {
		UserInfo result = null;
		Finder finder = Finder.create();
		finder.append("from UserInfo u where u.username ='" + openid + "'");
		// finder.append(" and u.password = '" + password + "'");
		List<UserInfo> us = dao.find(finder);
		if (us != null && us.size() > 0) {
			result = us.get(0);
		} else {
			UserInfo user = new UserInfo();
			user.setUsername(openid);
			user.setName(nickname);
			user.setName(nickname);
			user.setAvatar(figureurl_qq_1);
			user.setPlainPassword("123456");
			entryptPassword(user);
			result = dao.save(user);
		}
		return result;
	}
}