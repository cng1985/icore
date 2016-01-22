package com.ada.user.work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ada.user.service.UserInfoService;
import com.ada.user.service.UserNotificationMemberService;
import com.ada.user.service.UserNotificationService;

@Component
public class NotificationWork {

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private UserNotificationMemberService userNotificationMemberService;

	@Autowired
	private UserNotificationService userNotificationService;

	public void push(Long nid) {

		NotificationSendThread2 send=new NotificationSendThread2();
		send.setNid(nid);
		send.setUserInfoService(userInfoService);
		send.setUserNotificationMemberService(userNotificationMemberService);
		send.setUserNotificationService(userNotificationService);
		send.start();
		
	}


}
