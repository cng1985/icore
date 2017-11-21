package com.ada.user.dao.impl;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.CriteriaDaoImpl;
import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.ada.user.dao.UserInfoDao;
import com.ada.user.dao.UserOauthTokenDao;
import com.ada.user.dao.UserQQDao;
import com.ada.user.entity.UserInfo;
import com.ada.user.entity.UserOauthToken;
import com.ada.user.entity.UserQQ;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.young.http.Connection;
import com.young.http.HttpConnection;
import com.young.security.Digests;
import com.young.security.Encodes;

@Repository
public class UserQQDaoImpl extends CriteriaDaoImpl<UserQQ, Long> implements UserQQDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	@Autowired
	UserInfoDao userInfoDao;

	public UserQQ findById(Long id) {
		UserQQ entity = get(id);
		return entity;
	}

	public UserQQ save(UserQQ bean) {
		getSession().save(bean);
		return bean;
	}

	public UserQQ deleteById(Long id) {
		UserQQ entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	protected Class<UserQQ> getEntityClass() {
		return UserQQ.class;
	}

	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
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

	@Override
	public UserQQ login(String access_token, String openid, String oauth_consumer_key) throws Exception {
		if (access_token == null) {
			return null;
		}
		if (openid == null) {
			return null;
		}
		Finder finder = Finder.create();
		finder.append("from UserQQ u where u.openid =:openid");
		finder.setParam("openid", openid);
		UserQQ qq = findOne(finder);
		if (qq == null) {

			qq = new UserQQ();
			try {
				Connection con = HttpConnection.connect("https://graph.qq.com/user/get_user_info");
				con.data("oauth_consumer_key", oauth_consumer_key);
				con.data("access_token", access_token);
				con.data("openid", openid);
				con.data("format", "json");
				String body;
				body = con.execute().body();
				JsonParser parser = new JsonParser();
				JsonElement e = parser.parse(body);
				if (e.getAsJsonObject().get("ret").getAsInt() == 0) {
					String name = "nickname";
					String nickname = getString(e, name);
			
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			qq.setOpenid(openid);
			qq.setAccessToken(access_token);
			qq.setLastDate(new Date());
		}
		return qq;
	}

	private String getString(JsonElement e, String name) {
		String result = "";
		try {
			result = e.getAsJsonObject().get(name).getAsString();
		} catch (Exception e2) {
			// TODO: handle exception
		}
		return result;
	}

	private int getInteger(JsonElement e, String name) {
		int result = 0;
		try {
			result = e.getAsJsonObject().get(name).getAsInt();
		} catch (Exception e2) {
			// TODO: handle exception
		}
		return result;
	}
	@Autowired
	private UserOauthTokenDao tokenDao;
	@Override
	public UserInfo loginOauth(String access_token, String openid, String oauth_consumer_key) {
		
		UserInfo result=null;
		
		try {
			Connection con = HttpConnection.connect("https://graph.qq.com/user/get_user_info");
			con.data("oauth_consumer_key", oauth_consumer_key);
			con.data("access_token", access_token);
			con.data("openid", openid);
			con.data("format", "json");
			String body;
			body = con.execute().body();
			
			JsonParser parser = new JsonParser();
			JsonElement e = parser.parse(body);
			if (e.getAsJsonObject().get("ret").getAsInt() != 0) {
				return null;
			}

			Gson gson = new Gson();
			UserQQ qq = gson.fromJson(body, UserQQ.class);
			if (qq!=null&&qq.getRet()!=null&&qq.getRet()==0) {
				qq.setOpenid(openid);
				qq.setAccessToken(access_token);
				qq.setAppid(oauth_consumer_key);
				UserOauthToken utoken = tokenDao.findByUid(qq.getOpenid(), "qq");
				if (utoken == null) {
					String username = "qq_" + qq.getOpenid();
					UserInfo user = userInfoDao.findByName(username);
					if (user == null) {
						user = new UserInfo();
						user.setUsername(username);
						user.setPlainPassword("123456");
						user.setRegisterType("qq");
						user.setAvatar(qq.getFigureurl_2());
						user.setName(qq.getNickname());
						entryptPassword(user);
						user = userInfoDao.save(user);
					}
					utoken = new UserOauthToken();
					utoken.setAccess_token(access_token);
					utoken.setUid(qq.getOpenid());
					utoken.setToken_type("qq");
					utoken.setUser(user);
					utoken.setLoginSize(1);
					tokenDao.save(utoken);
					result = utoken.getUser();
					save(qq);
				} else {
					Integer size = utoken.getLoginSize();
					if (size == null) {
						size = 1;
					}
					size++;
					utoken.setLoginSize(size);
					utoken.setLastDate(new Date());
					utoken.setAccess_token(access_token);
					result = utoken.getUser();
					Integer sizes = result.getLoginSize();
					if (sizes==null) {
						sizes=1;
					}
					sizes++;
					result.setLoginSize(sizes);
					result.setLastDate(new Date());
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}