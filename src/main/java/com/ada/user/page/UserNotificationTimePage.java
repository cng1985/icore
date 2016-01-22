package com.ada.user.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.user.entity.UserNotificationTime;
public class UserNotificationTimePage extends PageRpc<UserNotificationTime> {

	public UserNotificationTimePage(Pagination<UserNotificationTime> page) {
		super(page);
	}

}
