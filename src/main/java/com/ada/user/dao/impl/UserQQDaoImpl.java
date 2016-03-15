package com.ada.user.dao.impl;

import java.io.IOException;

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
		UserQQ result = new UserQQ();
		Finder finder = Finder.create();
		finder.append("from UserQQ u where u.openid =:openid");
		finder.setParam("openid", openid);
		UserQQ qq = findOne(finder);
		if (qq==null) {
			
				qq=new UserQQ();
				UserInfo info=new UserInfo();
				info.setUsername(openid);
				info.setPlainPassword("123456");
				entryptPassword(info);
				info=userInfoDao.save(info);
				qq.setUser(info);
				
				Connection con = HttpConnection.connect("https://graph.qq.com/user/get_user_info");
				con.data("oauth_consumer_key",oauth_consumer_key);
				con.data("access_token", access_token);
				con.data("openid", openid);
				con.data("format", "json");
				String body;
				body = con.execute().body();
				JsonParser parser = new JsonParser();
				JsonElement e = parser.parse(body);
				String nickname = e.getAsJsonObject().get("nickname").getAsString();
				String gender = e.getAsJsonObject().get("gender").getAsString();
				String province = e.getAsJsonObject().get("province").getAsString();
				String city = e.getAsJsonObject().get("city").getAsString();
				int year = e.getAsJsonObject().get("year").getAsInt();
				String figureurl = e.getAsJsonObject().get("figureurl").getAsString();
				String figureurl_1 = e.getAsJsonObject().get("figureurl_1").getAsString();
				String figureurl_2 = e.getAsJsonObject().get("figureurl_2").getAsString();
				String figureurl_qq_1 = e.getAsJsonObject().get("figureurl_qq_1").getAsString();
				String figureurl_qq_2 = e.getAsJsonObject().get("figureurl_qq_2").getAsString();
				int is_yellow_vip = e.getAsJsonObject().get("is_yellow_vip").getAsInt();
				int vip = e.getAsJsonObject().get("vip").getAsInt();
				int yellow_vip_level = e.getAsJsonObject().get("yellow_vip_level").getAsInt();
				int level = e.getAsJsonObject().get("level").getAsInt();
				int is_yellow_year_vip = e.getAsJsonObject().get("is_yellow_year_vip").getAsInt();
				System.out.println(is_yellow_year_vip);
				qq.setAccessToken(access_token);
				qq.setOpenid(openid);
				qq.setNickName(nickname);
				qq.setGender(gender);
				qq.setProvince(province);
				qq.setCity(city);
				qq.setYear(year);
				qq.setFigureUrl(figureurl);
				qq.setFigureUrl1(figureurl_1);
				qq.setFigureUrl2(figureurl_2);
				qq.setFigureurlQq1(figureurl_qq_1);
				qq.setFigureurlQq2(figureurl_qq_2);
				qq.setYellowVip(is_yellow_vip);
				qq.setVip(vip);
				qq.setLevel(level);
				qq.setYellowYearVip(is_yellow_year_vip);
				qq.setYellowVipLevel(yellow_vip_level);
				qq=save(qq);
			
		}
		return qq;
	}
}