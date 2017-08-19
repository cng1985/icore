package com.ada.user.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.user.entity.UserMessage;

public interface UserMessageDao extends CriteriaDao<UserMessage, Long>{
	Pagination getPage(int pageNo, int pageSize);

	UserMessage findById(Long id);

	UserMessage save(UserMessage bean);

	UserMessage updateByUpdater(Updater<UserMessage> updater);

	UserMessage deleteById(Long id);
}