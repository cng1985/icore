package com.ada.user.dao;


import  com.quhaodian.data.core.CriteriaDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import  com.ada.user.entity.UserMessageSubject;

public interface UserMessageSubjectDao extends CriteriaDao<UserMessageSubject, Long>{
	Pagination getPage(int pageNo, int pageSize);

	UserMessageSubject findById(Long id);

	UserMessageSubject save(UserMessageSubject bean);

	UserMessageSubject updateByUpdater(Updater<UserMessageSubject> updater);

	UserMessageSubject deleteById(Long id);
}