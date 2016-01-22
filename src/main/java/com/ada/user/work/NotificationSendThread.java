package com.ada.user.work;

import java.util.List;

import com.ada.data.core.Pagination;
import com.ada.user.entity.UserInfo;
import com.ada.user.entity.UserNotification;
import com.ada.user.entity.UserNotificationMember;
import com.ada.user.service.UserInfoService;
import com.ada.user.service.UserNotificationMemberService;
import com.ada.user.service.UserNotificationService;

public class NotificationSendThread extends Thread {

	private static final int sendmax = 200;

	private UserInfoService userInfoService;

	private UserNotificationMemberService userNotificationMemberService;

	private UserNotificationService userNotificationService;

	private Long nid;

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public UserNotificationMemberService getUserNotificationMemberService() {
		return userNotificationMemberService;
	}

	public void setUserNotificationMemberService(UserNotificationMemberService userNotificationMemberService) {
		this.userNotificationMemberService = userNotificationMemberService;
	}

	public UserNotificationService getUserNotificationService() {
		return userNotificationService;
	}

	public void setUserNotificationService(UserNotificationService userNotificationService) {
		this.userNotificationService = userNotificationService;
	}

	public Long getNid() {
		return nid;
	}

	public void setNid(Long nid) {
		this.nid = nid;
	}

	int index = 0;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();

		UserNotification noc = userNotificationService.findById(nid);

		if (noc != null) {
			Pagination page = userInfoService.getPage(1, sendmax);
			sends(noc, page);

			for (int i = 2; i < page.getTotalPage(); i++) {
				page = userInfoService.getPage(i, sendmax);
				sends(noc, page);
			}
			noc.setNums(index);
			userNotificationService.update(noc);
		}
	}

	/**
	 * @param noc
	 * @param page
	 */
	private void sends(UserNotification noc, Pagination page) {
		List<UserInfo> us = page.getList();
		if (us != null && us.size() > 0) {
			for (UserInfo userInfo : us) {
				UserNotificationMember bean = new UserNotificationMember();
				bean.setNotification(noc);
				bean.setUser(userInfo);
				bean.setState(1);
				userNotificationMemberService.save(bean);
				index++;
			}
		}
	}
}
