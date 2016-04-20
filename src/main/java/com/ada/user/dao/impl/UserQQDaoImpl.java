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
import com.ada.user.dao.UserQQDao;
import com.ada.user.entity.UserInfo;
import com.ada.user.entity.UserQQ;
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
					qq.setNickName(nickname);
					String figureurl_qq_1 = getString(e, "figureurl_qq_1");
					qq.setFigureurlQq1(figureurl_qq_1);
					String gender = getString(e, "gender");
					qq.setGender(gender);
					String province = getString(e, "province");
					qq.setProvince(province);
					String city = getString(e, "city");
					qq.setCity(city);
					int year = getInteger(e, "year");
					qq.setYear(year);
					String figureurl = getString(e, "figureurl");
					qq.setFigureUrl(figureurl);
					String figureurl_1 = getString(e, "figureurl_1");
					qq.setFigureUrl1(figureurl_1);
					String figureurl_2 = getString(e, "figureurl_2");
					qq.setFigureUrl2(figureurl_2);

					String figureurl_qq_2 = getString(e, "figureurl_qq_2");
					qq.setFigureurlQq2(figureurl_qq_2);

					UserInfo info = userInfoDao.findByName(openid);
					if (info == null) {
						info = new UserInfo();
						info.setUsername(openid);
						info.setPlainPassword("123456");
						info.setRegisterType("qq");
						info.setHeadimg(figureurl_qq_1);
						info.setName(nickname);
						entryptPassword(info);
						info = userInfoDao.save(info);
					}

					qq.setUser(info);
					qq.setOpenid(openid);
					qq.setAccessToken(access_token);
					qq = save(qq);

					int is_yellow_vip = getInteger(e, "is_yellow_vip");
					qq.setYellowVip(is_yellow_vip);
					int vip = getInteger(e, "vip");
					qq.setVip(vip);
					int yellow_vip_level = getInteger(e, "yellow_vip_level");
					qq.setYellowVipLevel(yellow_vip_level);
					int level = getInteger(e, "level");
					qq.setLevel(level);
					int is_yellow_year_vip = getInteger(e, "is_yellow_year_vip");
					qq.setYellowYearVip(is_yellow_year_vip);
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
}