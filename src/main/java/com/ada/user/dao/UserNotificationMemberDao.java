package com.ada.user.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.user.entity.UserNotificationMember;

public interface UserNotificationMemberDao extends CriteriaDao<UserNotificationMember, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserNotificationMember findById(Long id);

	public UserNotificationMember save(UserNotificationMember bean);

	public UserNotificationMember updateByUpdater(Updater<UserNotificationMember> updater);

	public UserNotificationMember deleteById(Long id);
}