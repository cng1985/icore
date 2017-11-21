package com.ada.user.dao;


import  com.quhaodian.data.core.CriteriaDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import  com.ada.user.entity.UserMessageMember;

public interface UserMessageMemberDao extends CriteriaDao<UserMessageMember, Long>{
	Pagination getPage(int pageNo, int pageSize);

	UserMessageMember findById(Long id);

	UserMessageMember save(UserMessageMember bean);

	UserMessageMember updateByUpdater(Updater<UserMessageMember> updater);

	UserMessageMember deleteById(Long id);
}