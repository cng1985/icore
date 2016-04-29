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
import com.ada.user.dao.UserOauthWeiboDao;
import com.ada.user.entity.UserInfo;
import com.ada.user.entity.UserOauthToken;
import com.ada.user.entity.UserOauthWeibo;
import com.ada.user.page.UserOauthWeiboPage;
import com.ada.user.service.UserOauthWeiboService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.young.http.Connection;
import com.young.http.HttpConnection;
import com.young.security.Digests;
import com.young.security.Encodes;

@Service
@Transactional
public class UserOauthWeiboServiceImpl implements UserOauthWeiboService {

	@Transactional(readOnly = true)
	public UserOauthWeibo findById(Long id) {
		UserOauthWeibo entity = dao.findById(id);
		return entity;
	}

	@Transactional
	public UserOauthWeibo save(UserOauthWeibo bean) {
		dao.save(bean);
		return bean;
	}

	@Transactional
	public UserOauthWeibo update(UserOauthWeibo bean) {
		Updater<UserOauthWeibo> updater = new Updater<UserOauthWeibo>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public UserOauthWeibo deleteById(Long id) {
		UserOauthWeibo bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public UserOauthWeibo[] deleteByIds(Long[] ids) {
		UserOauthWeibo[] beans = new UserOauthWeibo[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserOauthWeiboDao dao;

	@Autowired
	private UserOauthTokenDao tokenDao;

	@Autowired
	public void setDao(UserOauthWeiboDao dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	public UserOauthWeiboPage getPage(int pageNo, int pageSize) {
		UserOauthWeiboPage result = null;
		Finder finder = Finder.create();
		finder.append("from UserOauthWeibo f ");
		finder.append(" order by f.id desc  ");
		Pagination<UserOauthWeibo> page = dao.find(finder, pageNo, pageSize);
		result = new UserOauthWeiboPage(page);
		return result;
	}

	@Transactional(readOnly = true)
	public Page<UserOauthWeibo> findPage(Pageable pageable) {
		return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters) {

		return dao.count(filters);

	}

	@Transactional(readOnly = true)
	public List<UserOauthWeibo> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders) {

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
	public UserInfo login(String token) {
		UserInfo result = null;
		try {

			Connection con = HttpConnection.connect("https://api.weibo.com/2/account/get_uid.json");
			con.data("access_token", token);
			con.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:45.0) Gecko/20100101 Firefox/45.0");

			String backjson = con.execute().body();

			JsonParser parser = new JsonParser();
			JsonElement e = parser.parse(backjson);
			String uid = e.getAsJsonObject().get("uid").getAsString();

			UserOauthToken utoken = tokenDao.findByUid(uid, "weibo");
			if (utoken.getId() != null && utoken.getId() > 0) {
				utoken.setLastDate(new Date());
				utoken.setAccess_token(token);
				result = utoken.getUser();

			} else {
				String username = "weibo_" + uid;
				UserInfo user = userInfoDao.findByName(username);
				if (user == null) {
					user = new UserInfo();
					user.setUsername(username);
					user.setPlainPassword("123456");
					user.setRegisterType("weibo");
					// user.setHeadimg(result.getAvatar());
					// user.setName(result.getName());
					entryptPassword(user);
					user = userInfoDao.save(user);
				}

				UserOauthToken token2 = new UserOauthToken();
				token2.setAccess_token(token);
				token2.setUid(uid);
				token2.setToken_type("weibo");
				token2.setUser(user);
				tokenDao.save(token2);
				result = user;

				Connection infocon = HttpConnection.connect("https://api.weibo.com/2/users/show.json");
				infocon.data("access_token", token);
				infocon.data("uid", uid);
				infocon.header("User-Agent",
						"Mozilla/5.0 (Windows NT 10.0; WOW64; rv:45.0) Gecko/20100101 Firefox/45.0");
				String uifos = infocon.execute().body();
				Gson gson = new Gson();
				UserOauthWeibo weibo = gson.fromJson(uifos, UserOauthWeibo.class);
				UserOauthWeibo old = dao.findById(weibo.getId());
				if (old==null) {
					dao.save(weibo);
				}
				user.setName(weibo.getName());
				user.setHeadimg(weibo.getAvatar_large());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}