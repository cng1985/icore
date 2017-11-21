package com.ada.user.dao;


import  com.quhaodian.data.core.CriteriaDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import  com.ada.user.entity.UserCode;

public interface UserCodeDao extends CriteriaDao<UserCode,Long>{
	Pagination getPage(int pageNo, int pageSize);

	UserCode findById(Long id);

	UserCode findByCode(String code);

	UserCode save(UserCode bean);

	UserCode updateByUpdater(Updater<UserCode> updater);

	UserCode deleteById(Long id);
}