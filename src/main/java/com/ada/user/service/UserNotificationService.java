package com.ada.user.service;

import java.util.List;

import com.ada.data.core.Pagination;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import com.ada.user.entity.UserInfo;
import com.ada.user.entity.UserNotification;
import com.ada.user.page.UserNotificationPage;
import com.openyelp.annotation.RestFul;

@RestFul(api=UserNotificationService.class,value="UserNotificationService")
public interface UserNotificationService {
	public Pagination getPage(int pageNo, int pageSize);

	public UserNotification findById(Long id);

	public UserNotification save(UserNotification bean);
	
	public UserNotification notice(UserNotification bean);

	public UserNotification noticeAll(UserNotification bean);

	
	public UserNotification send(UserNotification bean,List<UserInfo> users);

	public UserNotification send(Long nid,List<UserInfo> users);

	public UserNotification update(UserNotification bean);

	public UserNotification deleteById(Long id);
	
	public UserNotification[] deleteByIds(Long[] ids);
	
	
	public	UserNotificationPage pageByUser(Long userid,int pageNo, int pageSize);
	public	UserNotificationPage pageByUserUnRead(Long userid,int pageNo, int pageSize);

	public Page<UserNotification> findPage(Pageable pageable);

}