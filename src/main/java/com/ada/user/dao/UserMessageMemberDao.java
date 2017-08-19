package com.ada.user.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.user.entity.UserMessageMember;

public interface UserMessageMemberDao extends CriteriaDao<UserMessageMember, Long>{
	Pagination getPage(int pageNo, int pageSize);

	UserMessageMember findById(Long id);

	UserMessageMember save(UserMessageMember bean);

	UserMessageMember updateByUpdater(Updater<UserMessageMember> updater);

	UserMessageMember deleteById(Long id);
}