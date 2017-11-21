package com.ada.user.dao;


import  com.quhaodian.data.core.CriteriaDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import com.ada.user.entity.UserInfo;
import  com.ada.user.entity.UserQQ;

public interface UserQQDao extends CriteriaDao<UserQQ, Long>{
	Pagination getPage(int pageNo, int pageSize);

	UserQQ findById(Long id);

	UserQQ save(UserQQ bean);

	UserQQ updateByUpdater(Updater<UserQQ> updater);

	UserQQ deleteById(Long id);
	
	
	UserQQ login(String access_token, String openid, String oauth_consumer_key)throws Exception;

	
	UserInfo loginOauth(String access_token, String openid, String oauth_consumer_key);

}