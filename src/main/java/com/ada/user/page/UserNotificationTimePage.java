package com.ada.user.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.user.entity.UserNotificationTime;
public class UserNotificationTimePage extends PageRpc<UserNotificationTime> {

	public UserNotificationTimePage(Pagination<UserNotificationTime> page) {
		super(page);
	}

}
