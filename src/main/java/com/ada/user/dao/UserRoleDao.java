package com.ada.user.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.user.entity.UserRole;

public interface UserRoleDao extends CriteriaDao<UserRole, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserRole findById(Long id);

	public UserRole save(UserRole bean);

	public UserRole updateByUpdater(Updater<UserRole> updater);

	public UserRole deleteById(Long id);
}