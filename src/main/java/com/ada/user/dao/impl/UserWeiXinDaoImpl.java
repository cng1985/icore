package com.ada.user.dao.impl;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.user.dao.UserInfoDao;
import com.ada.user.dao.UserOauthTokenDao;
import com.ada.user.dao.UserWeiXinDao;
import com.ada.user.entity.UserInfo;
import com.ada.user.entity.UserOauthToken;
import com.ada.user.entity.UserQQ;
import com.ada.user.entity.UserWeiXin;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.young.http.Connection;
import com.young.http.HttpConnection;
import com.young.security.Digests;
import com.young.security.Encodes;

@Repository
public class UserWeiXinDaoImpl extends CriteriaDaoImpl<UserWeiXin, Long> implements UserWeiXinDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
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

	public UserWeiXin findById(Long id) {
		UserWeiXin entity = get(id);
		return entity;
	}

	public UserWeiXin save(UserWeiXin bean) {
		getSession().save(bean);
		return bean;
	}

	public UserWeiXin deleteById(Long id) {
		UserWeiXin entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	protected Class<UserWeiXin> getEntityClass() {
		return UserWeiXin.class;
	}

	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Autowired
	UserInfoDao userInfoDao;

	@Override
	public UserWeiXin login(String access_token, String openid) throws Exception {
		Finder finder = Finder.create();
		finder.append("from UserWeiXin u where u.openid =:openid");
		finder.setParam("openid", openid);
		UserWeiXin qq = findOne(finder);
		if (qq == null) {

			qq = new UserWeiXin();
			UserInfo info = userInfoDao.findByName(openid);
			if (info == null) {
				info = new UserInfo();
				info.setUsername(openid);
				info.setPlainPassword("123456");
				entryptPassword(info);
				info = userInfoDao.save(info);
			}
			qq.setOpenid(openid);
			qq.setAccessToken(access_token);
			qq = save(qq);
			try {
				Connection con = HttpConnection.connect("https://api.weixin.qq.com/sns/userinfo");
				con.data("access_token", access_token);
				con.data("openid", openid);
				String body;
				body = con.execute().body();
				JsonParser parser = new JsonParser();
				JsonElement e = parser.parse(body);
				String nickname = e.getAsJsonObject().get("nickname").getAsString();
				qq.setNickName(nickname);
				String headimgurl = e.getAsJsonObject().get("headimgurl").getAsString();
				qq.setHeadimgurl(headimgurl);
				String city = e.getAsJsonObject().get("city").getAsString();
				qq.setCity(city);
				Integer sexid = e.getAsJsonObject().get("sex").getAsInt();
				String sex = "男";
				if (sexid == null || sexid == 0) {
					sex = "女";
				}
				qq.setSex(sex);
				String province = e.getAsJsonObject().get("province").getAsString();
				qq.setProvince(province);
				String country = getString(e, "country");
				qq.setCountry(country);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			qq.setAccessToken(access_token);
			qq.setLastDate(new Date());
		}
		return qq;
	}

	@Autowired
	private UserOauthTokenDao tokenDao;

	@Override
	public UserInfo loginOauth(String access_token, String openid) {
		UserInfo result = new UserInfo();

		try {
			Connection con = HttpConnection.connect("https://api.weixin.qq.com/sns/userinfo");
			con.data("access_token", access_token);
			con.data("openid", openid);
			String body;
			body = con.execute().body();

			UserWeiXin weixin = new UserWeiXin();
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(body);
			String nickname = getString(element, "nickname");
			weixin.setNickName(nickname);
			String headimgurl = getString(element, "headimgurl");
			weixin.setHeadimgurl(headimgurl);
			String city = getString(element, "city");
			weixin.setCity(city);
			Integer sexid = getInt(element, "sex");
			String sex = "男";
			if (sexid == null || sexid == 0) {
				sex = "女";
			}
			weixin.setSex(sex);
			String province = getString(element, "province");
			weixin.setProvince(province);
			String country = getString(element, "country");
			weixin.setCountry(country);
			weixin.setUnionid(getString(element, "unionid"));
			weixin.setAccessToken(access_token);
			weixin.setOpenid(openid);
			if (weixin.getUnionid() != null && weixin.getUnionid().length() > 5) {
				UserOauthToken utoken = tokenDao.findByUid(weixin.getUnionid(), "weixin");
				if (utoken == null) {
					String username = "weixin_" + weixin.getUnionid();
					UserInfo user = userInfoDao.findByName(username);
					if (user == null) {
						user = new UserInfo();
						user.setUsername(username);
						user.setPlainPassword("123456");
						user.setRegisterType("weixin");
						user.setAvatar(weixin.getHeadimgurl());
						user.setName(weixin.getNickName());
						entryptPassword(user);
						user = userInfoDao.save(user);
					}
					utoken = new UserOauthToken();
					utoken.setAccess_token(access_token);
					utoken.setUid(weixin.getUnionid());
					utoken.setToken_type("weixin");
					utoken.setUser(user);
					utoken.setLoginSize(1);
					tokenDao.save(utoken);
					result = utoken.getUser();
					save(weixin);
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
					if (sizes == null) {
						sizes = 1;
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

	/**
	 * @param element
	 * @return
	 */
	private String getString(JsonElement element, String key) {

		String result = "";
		try {
			result = element.getAsJsonObject().get(key).getAsString();
		} catch (Exception e2) {
		}

		return result;
	}

	private Integer getInt(JsonElement element, String key) {

		Integer result = 0;
		try {
			result = element.getAsJsonObject().get(key).getAsInt();
		} catch (Exception e2) {
		}
		return result;
	}
}