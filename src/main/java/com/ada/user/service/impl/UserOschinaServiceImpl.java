package com.ada.user.service.impl;

import java.io.IOException;
import java.util.Date;
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
import com.ada.user.dao.UserInfoDao;
import com.ada.user.dao.UserOauthTokenDao;
import com.ada.user.dao.UserOschinaDao;
import com.ada.user.entity.UserInfo;
import com.ada.user.entity.UserOauthToken;
import com.ada.user.entity.UserOschina;
import com.ada.user.page.UserOschinaPage;
import com.ada.user.service.UserOschinaService;
import com.google.gson.Gson;
import com.young.http.Connection;
import com.young.http.HttpConnection;
import com.young.security.Digests;
import com.young.security.Encodes;

@Service
@Transactional
public class UserOschinaServiceImpl implements UserOschinaService {

	@Transactional(readOnly = true)
	public UserOschina findById(Long id) {
		UserOschina entity = dao.findById(id);
		return entity;
	}

	@Transactional
	public UserOschina save(UserOschina bean) {
		dao.save(bean);
		return bean;
	}

	@Transactional
	public UserOschina update(UserOschina bean) {
		Updater<UserOschina> updater = new Updater<UserOschina>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public UserOschina deleteById(Long id) {
		UserOschina bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public UserOschina[] deleteByIds(Long[] ids) {
		UserOschina[] beans = new UserOschina[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserOschinaDao dao;

	@Autowired
	private UserOauthTokenDao tokenDao;

	@Autowired
	public void setDao(UserOschinaDao dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	public UserOschinaPage getPage(int pageNo, int pageSize) {
		UserOschinaPage result = null;
		Finder finder = Finder.create();
		finder.append("from UserOschina f ");
		finder.append(" order by f.id desc  ");
		Pagination<UserOschina> page = dao.find(finder, pageNo, pageSize);
		result = new UserOschinaPage(page);
		return result;
	}

	@Transactional(readOnly = true)
	public Page<UserOschina> findPage(Pageable pageable) {
		return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters) {

		return dao.count(filters);

	}

	@Transactional(readOnly = true)
	public List<UserOschina> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders) {

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

	@Override
	public UserInfo login(String client_id, String client_secret, String grant_type, String redirect_uri, String code) {
		UserInfo result = new UserInfo();

		try {
			Connection con = HttpConnection.connect("http://www.oschina.net/action/openapi/token");
			con.data("client_id", client_id);
			con.data("client_secret", client_secret);
			con.data("grant_type", grant_type);
			con.data("redirect_uri", redirect_uri);
			con.data("code", code);
			con.data("dataType", "json");
			con.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:45.0) Gecko/20100101 Firefox/45.0");
			String body = con.execute().body();
			Gson gson = new Gson();
			UserOauthToken token = gson.fromJson(body, UserOauthToken.class);

			UserOauthToken utoken = tokenDao.findByUid(token.getUid(), "oschina");
			if (utoken!= null && utoken.getId() > 0) {
				utoken.setLastDate(new Date());
				utoken.setAccess_token(token.getAccess_token());
				// result = utoken.getUser();

			} else {

				Connection info = HttpConnection.connect("http://www.oschina.net/action/openapi/user");

				info.data("access_token", token.getAccess_token());
				info.data("dataType", "json");
				info.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:45.0) Gecko/20100101 Firefox/45.0");
				String infojson = info.execute().body();

				UserOschina oschina = gson.fromJson(infojson, UserOschina.class);

				String username = "oschina_" + result.getId();
				UserInfo user = userInfoDao.findByName(username);
				if (user == null) {
					user = new UserInfo();
					user.setUsername(username);
					user.setPlainPassword("123456");
					user.setRegisterType("oschina");
					user.setHeadimg(oschina.getAvatar());
					user.setName(oschina.getName());
					entryptPassword(user);
					user = userInfoDao.save(user);
				}
				token.setUser(user);
				token.setToken_type("oschina");
				tokenDao.save(token);
				result = user;

				oschina.setUser(user);
				
				UserOschina temp=	dao.findById(oschina.getId());
				if (temp==null) {
					dao.save(oschina);
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
}