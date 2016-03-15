package com.ada.user.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.user.entity.UserQQ;

public interface UserQQDao extends CriteriaDao<UserQQ, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserQQ findById(Long id);

	public UserQQ save(UserQQ bean);

	public UserQQ updateByUpdater(Updater<UserQQ> updater);

	public UserQQ deleteById(Long id);
	
	
	public UserQQ login(String access_token, String openid, String oauth_consumer_key)throws Exception;

}