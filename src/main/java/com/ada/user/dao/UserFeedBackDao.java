package com.ada.user.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.user.entity.UserFeedBack;

public interface UserFeedBackDao extends CriteriaDao<UserFeedBack, Long>{
	Pagination getPage(int pageNo, int pageSize);

	UserFeedBack findById(Long id);

	UserFeedBack save(UserFeedBack bean);

	UserFeedBack updateByUpdater(Updater<UserFeedBack> updater);

	UserFeedBack deleteById(Long id);
}