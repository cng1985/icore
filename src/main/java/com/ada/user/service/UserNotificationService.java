package com.ada.user.service;

import com.ada.data.core.Pagination;
import com.ada.user.entity.UserNotification;
import com.ada.user.page.UserNotificationPage;
import com.openyelp.annotation.RestFul;

@RestFul(api=UserNotificationService.class,value="UserNotificationService")
public interface UserNotificationService {
	public Pagination getPage(int pageNo, int pageSize);

	public UserNotification findById(Long id);

	public UserNotification save(UserNotification bean);

	public UserNotification update(UserNotification bean);

	public UserNotification deleteById(Long id);
	
	public UserNotification[] deleteByIds(Long[] ids);
	
	
	public	UserNotificationPage pageByUser(Long userid,int pageNo, int pageSize);
	public	UserNotificationPage pageByUserUnRead(Long userid,int pageNo, int pageSize);

}