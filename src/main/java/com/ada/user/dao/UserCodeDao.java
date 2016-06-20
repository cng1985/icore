package com.ada.user.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.user.entity.UserCode;

public interface UserCodeDao extends CriteriaDao<UserCode,Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserCode findById(Long id);

	public UserCode findByCode(String code);

	public UserCode save(UserCode bean);

	public UserCode updateByUpdater(Updater<UserCode> updater);

	public UserCode deleteById(Long id);
}