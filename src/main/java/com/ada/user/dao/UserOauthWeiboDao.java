package com.ada.user.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.user.entity.UserOauthWeibo;

public interface UserOauthWeiboDao extends CriteriaDao<UserOauthWeibo, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserOauthWeibo findById(Long id);

	public UserOauthWeibo save(UserOauthWeibo bean);

	public UserOauthWeibo updateByUpdater(Updater<UserOauthWeibo> updater);

	public UserOauthWeibo deleteById(Long id);
}