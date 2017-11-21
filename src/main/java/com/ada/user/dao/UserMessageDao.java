package com.ada.user.dao;


import  com.quhaodian.data.core.CriteriaDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import  com.ada.user.entity.UserMessage;

public interface UserMessageDao extends CriteriaDao<UserMessage, Long>{
	Pagination getPage(int pageNo, int pageSize);

	UserMessage findById(Long id);

	UserMessage save(UserMessage bean);

	UserMessage updateByUpdater(Updater<UserMessage> updater);

	UserMessage deleteById(Long id);
}