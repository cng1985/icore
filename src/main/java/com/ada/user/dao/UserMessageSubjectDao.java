package com.ada.user.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.user.entity.UserMessageSubject;

public interface UserMessageSubjectDao extends CriteriaDao<UserMessageSubject, Long>{
	Pagination getPage(int pageNo, int pageSize);

	UserMessageSubject findById(Long id);

	UserMessageSubject save(UserMessageSubject bean);

	UserMessageSubject updateByUpdater(Updater<UserMessageSubject> updater);

	UserMessageSubject deleteById(Long id);
}