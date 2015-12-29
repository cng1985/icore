package com.ada.user.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.user.entity.UserFeedBack;

public interface UserFeedBackDao extends CriteriaDao<UserFeedBack, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserFeedBack findById(Long id);

	public UserFeedBack save(UserFeedBack bean);

	public UserFeedBack updateByUpdater(Updater<UserFeedBack> updater);

	public UserFeedBack deleteById(Long id);
}