package com.ada.user.dao;


import  com.quhaodian.data.core.CriteriaDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import  com.ada.user.entity.UserRole;

public interface UserRoleDao extends CriteriaDao<UserRole, Long>{
	Pagination getPage(int pageNo, int pageSize);

	UserRole findById(Long id);

	UserRole save(UserRole bean);

	UserRole updateByUpdater(Updater<UserRole> updater);

	UserRole deleteById(Long id);
}