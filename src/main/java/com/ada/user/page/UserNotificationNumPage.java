package com.ada.user.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.user.entity.UserNotificationNum;
public class UserNotificationNumPage extends PageRpc<UserNotificationNum> {

	public UserNotificationNumPage(Pagination<UserNotificationNum> page) {
		super(page);
	}

}
