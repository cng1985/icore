package com.ada.user.dao.impl;

import java.io.IOException;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Pagination;
import com.ada.user.dao.UserInfoDao;
import com.ada.user.dao.UserOauthTokenDao;
import com.ada.user.dao.UserOauthWeiboDao;
import com.ada.user.entity.UserInfo;
import com.ada.user.entity.UserOauthToken;
import com.ada.user.entity.UserOauthWeibo;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.young.http.Connection;
import com.young.http.HttpConnection;
import com.young.security.Digests;
import com.young.security.Encodes;

@Repository
public class UserOauthWeiboDaoImpl extends CriteriaDaoImpl<UserOauthWeibo, Long> implements UserOauthWeiboDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public UserOauthWeibo findById(Long id) {
	    if (id==null) {
			return null;
		}
		UserOauthWeibo entity = get(id);
		return entity;
	}

	public UserOauthWeibo save(UserOauthWeibo bean) {
		getSession().save(bean);
		return bean;
	}

	public UserOauthWeibo deleteById(Long id) {
		UserOauthWeibo entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserOauthWeibo> getEntityClass() {
		return UserOauthWeibo.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
	@Autowired
	UserInfoDao userInfoDao;
	
	@Autowired
	private UserOauthTokenDao tokenDao;

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

	@Override
	public UserInfo loginOauth(String token) {
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
			if (utoken!=null&&utoken.getId() != null && utoken.getId() > 0) {
				utoken.setLastDate(new Date());
				utoken.setAccess_token(token);
				Integer size = utoken.getLoginSize();
				if (size == null) {
					size = 1;
				}
				size++;
				utoken.setLoginSize(size);
				utoken.setLastDate(new Date());
				utoken.setAccess_token(token);
				result = utoken.getUser();
				Integer sizes = result.getLogintimes();
				if (sizes==null) {
					sizes=1;
				}
				sizes++;
				result.setLogintimes(sizes);
				result.setLastDate(new Date());
				result = utoken.getUser();

			} else {
				

				Connection infocon = HttpConnection.connect("https://api.weibo.com/2/users/show.json");
				infocon.data("access_token", token);
				infocon.data("uid", uid);
				infocon.header("User-Agent",
						"Mozilla/5.0 (Windows NT 10.0; WOW64; rv:45.0) Gecko/20100101 Firefox/45.0");
				String uifos = infocon.execute().body();
				Gson gson = new Gson();
				UserOauthWeibo weibo = gson.fromJson(uifos, UserOauthWeibo.class);
				UserOauthWeibo old = findById(weibo.getId());
				if (old==null) {
					save(weibo);
				}
				
				
				String username = "weibo_" + uid;
				UserInfo user = userInfoDao.findByName(username);
				if (user == null) {
					user = new UserInfo();
					user.setUsername(username);
					user.setPlainPassword("123456");
					user.setRegisterType("weibo");
					user.setName(weibo.getName());
					user.setHeadimg(weibo.getAvatar_large());
					entryptPassword(user);
					user = userInfoDao.save(user);
				}
				UserOauthToken token2 = new UserOauthToken();
				token2.setAccess_token(token);
				token2.setUid(uid);
				token2.setToken_type("weibo");
				token2.setUser(user);
				token2.setLoginSize(1);
				tokenDao.save(token2);
				result = user;
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}