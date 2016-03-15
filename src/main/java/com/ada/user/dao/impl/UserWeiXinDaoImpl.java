package com.ada.user.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.user.dao.UserInfoDao;
import com.ada.user.dao.UserWeiXinDao;
import com.ada.user.entity.UserInfo;
import com.ada.user.entity.UserQQ;
import com.ada.user.entity.UserWeiXin;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.young.http.Connection;
import com.young.http.HttpConnection;

@Repository
public class UserWeiXinDaoImpl extends CriteriaDaoImpl<UserWeiXin, Long> implements UserWeiXinDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
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
	public void setSuperSessionFactory(SessionFactory sessionFactory){
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
		if (qq==null) {
			
				qq=new UserWeiXin();
				UserInfo info=new UserInfo();
				info.setUsername(openid);
				info=userInfoDao.save(info);
				qq.setUser(info);
				
				Connection con = HttpConnection.connect("https://api.weixin.qq.com/sns/userinfo");
				con.data("access_token", access_token);
				con.data("openid", openid);
				String body;
				body = con.execute().body();
				JsonParser parser = new JsonParser();
				JsonElement e = parser.parse(body);
				String nickname = e.getAsJsonObject().get("nickname").getAsString();
				Integer sexid = e.getAsJsonObject().get("sex").getAsInt();
				String sex="男";
				if (sexid==null||sexid==0) {
					 sex="女";
				}
				String city = e.getAsJsonObject().get("city").getAsString();
				String province = e.getAsJsonObject().get("province").getAsString();
				String country = e.getAsJsonObject().get("country").getAsString();
				String headimgurl = e.getAsJsonObject().get("headimgurl").getAsString();
				qq.setNickName(nickname);
				qq.setSex(sex);
				qq.setCity(city);
				qq.setProvince(province);
				qq.setCountry(country);
				qq.setHeadimgurl(headimgurl);
				qq=save(qq);
			
		}
		return qq;
	}
}