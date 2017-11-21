package com.ada.user.dao;


import  com.quhaodian.data.core.CriteriaDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import com.ada.user.entity.UserInfo;
import  com.ada.user.entity.UserOauthWeibo;

public interface UserOauthWeiboDao extends CriteriaDao<UserOauthWeibo, Long>{
	Pagination getPage(int pageNo, int pageSize);

	UserOauthWeibo findById(Long id);

	UserOauthWeibo save(UserOauthWeibo bean);

	UserOauthWeibo updateByUpdater(Updater<UserOauthWeibo> updater);

	UserOauthWeibo deleteById(Long id);
	
	
	UserInfo loginOauth(String token);

}