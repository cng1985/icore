package com.ada.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import com.ada.user.dao.UserGitHubDao;
import com.ada.user.dao.UserInfoDao;
import com.ada.user.entity.UserGitHub;
import com.ada.user.entity.UserInfo;
import com.ada.user.entity.UserOschina;
import com.ada.user.page.UserGitHubPage;
import com.ada.user.service.UserGitHubService;
import com.google.gson.Gson;
import com.young.http.Connection;
import com.young.http.HttpConnection;
import com.young.security.Digests;
import com.young.security.Encodes;

@Service
@Transactional
public class UserGitHubServiceImpl implements UserGitHubService {

	@Transactional(readOnly = true)
	public UserGitHub findById(Long id) {
		UserGitHub entity = dao.findById(id);
		return entity;
	}

	@Transactional
	public UserGitHub save(UserGitHub bean) {
		dao.save(bean);
		return bean;
	}

	@Transactional
	public UserGitHub update(UserGitHub bean) {
		Updater<UserGitHub> updater = new Updater<UserGitHub>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public UserGitHub deleteById(Long id) {
		UserGitHub bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public UserGitHub[] deleteByIds(Long[] ids) {
		UserGitHub[] beans = new UserGitHub[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserGitHubDao dao;

	@Autowired
	public void setDao(UserGitHubDao dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	public UserGitHubPage getPage(int pageNo, int pageSize) {
		UserGitHubPage result = null;
		Finder finder = Finder.create();
		finder.append("from UserGitHub f ");
		finder.append(" order by f.id desc  ");
		Pagination<UserGitHub> page = dao.find(finder, pageNo, pageSize);
		result = new UserGitHubPage(page);
		return result;
	}

	@Transactional(readOnly = true)
	public Page<UserGitHub> findPage(Pageable pageable) {
		return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters) {

		return dao.count(filters);

	}

	@Transactional(readOnly = true)
	public List<UserGitHub> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders) {

		return dao.findList(first, count, filters, orders);

	}
	/** 加密方法 */
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8; // 盐长度

	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	private void entryptPassword(UserInfo user) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user.setSalt(Encodes.encodeHex(salt));

		byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(), salt, HASH_INTERATIONS);
		user.setPassword(Encodes.encodeHex(hashPassword));
	}

	@Autowired
	UserInfoDao userInfoDao;

	@Transactional
	@Override
	public UserGitHub login(String token) {
		UserGitHub result = null;

		Gson gson = new Gson();

		Connection info = HttpConnection.connect("https://api.github.com/user");

		info.data("access_token", token);
		info.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:45.0) Gecko/20100101 Firefox/45.0");
		String infojson;
		try {
			infojson = info.execute().body();

			result = gson.fromJson(infojson, UserGitHub.class);
			
			UserGitHub d = dao.findById(result.getId());
			if (d == null) {
				String username = "github_" + result.getId();
				UserInfo user = userInfoDao.findByName(username);
				
				if (user == null) {
					user = new UserInfo();
					user.setUsername(username);
					user.setPlainPassword("123456");
					user.setRegisterType("github");
					user.setHeadimg(result.getAvatar_url());
					user.setName(result.getName());
					entryptPassword(user);
					user = userInfoDao.save(user);
				}
				result.setUser(user);
				result=dao.save(result);
			}else{
				result=d;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
}