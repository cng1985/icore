package com.ada.user.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import com.ada.user.entity.UserQQ;
import  com.ada.user.entity.UserWeiXin;

public interface UserWeiXinDao extends CriteriaDao<UserWeiXin, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserWeiXin findById(Long id);

	public UserWeiXin save(UserWeiXin bean);

	public UserWeiXin updateByUpdater(Updater<UserWeiXin> updater);

	public UserWeiXin deleteById(Long id);
	
	public UserWeiXin login(String access_token, String openid)throws Exception;
}