package com.ada.user.service;

import java.util.List;

import com.ada.data.core.Pagination;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import com.ada.user.entity.UserInfo;
import com.ada.user.entity.UserNotification;
import com.ada.user.page.UserNotificationPage;

public interface UserNotificationService {
	Pagination getPage(int pageNo, int pageSize);

	UserNotification findById(Long id);

	UserNotification save(UserNotification bean);
	
	UserNotification notice(UserNotification bean);

	UserNotification noticeAll(UserNotification bean);

	
	UserNotification send(UserNotification bean, List<UserInfo> users);

	UserNotification send(Long nid, List<UserInfo> users);

	UserNotification update(UserNotification bean);

	UserNotification deleteById(Long id);
	
	UserNotification[] deleteByIds(Long[] ids);
	
	
	UserNotificationPage pageByUser(Long userid, int pageNo, int pageSize);
	UserNotificationPage pageByUserUnRead(Long userid, int pageNo, int pageSize);

	Page<UserNotification> findPage(Pageable pageable);

}