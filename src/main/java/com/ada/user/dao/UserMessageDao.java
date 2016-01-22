package com.ada.user.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.user.entity.UserMessage;

public interface UserMessageDao extends CriteriaDao<UserMessage, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserMessage findById(Long id);

	public UserMessage save(UserMessage bean);

	public UserMessage updateByUpdater(Updater<UserMessage> updater);

	public UserMessage deleteById(Long id);
}