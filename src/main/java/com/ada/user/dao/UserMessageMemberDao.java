package com.ada.user.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.user.entity.UserMessageMember;

public interface UserMessageMemberDao extends CriteriaDao<UserMessageMember, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserMessageMember findById(Long id);

	public UserMessageMember save(UserMessageMember bean);

	public UserMessageMember updateByUpdater(Updater<UserMessageMember> updater);

	public UserMessageMember deleteById(Long id);
}