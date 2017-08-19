package com.ada.user.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.user.entity.UserNotificationMember;

public interface UserNotificationMemberDao extends CriteriaDao<UserNotificationMember, Long>{
	Pagination getPage(int pageNo, int pageSize);

	UserNotificationMember findById(Long id);

	UserNotificationMember save(UserNotificationMember bean);

	UserNotificationMember updateByUpdater(Updater<UserNotificationMember> updater);

	UserNotificationMember deleteById(Long id);
}