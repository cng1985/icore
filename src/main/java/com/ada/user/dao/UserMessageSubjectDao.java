package com.ada.user.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.user.entity.UserMessageSubject;

public interface UserMessageSubjectDao extends CriteriaDao<UserMessageSubject, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserMessageSubject findById(Long id);

	public UserMessageSubject save(UserMessageSubject bean);

	public UserMessageSubject updateByUpdater(Updater<UserMessageSubject> updater);

	public UserMessageSubject deleteById(Long id);
}