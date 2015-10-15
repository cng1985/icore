package com.ada.user.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.user.entity.UserInfo;

public interface UserInfoDao extends BaseDao<UserInfo, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserInfo findById(Long id);

	public UserInfo save(UserInfo bean);

	public UserInfo updateByUpdater(Updater<UserInfo> updater);

	public UserInfo deleteById(Long id);
}