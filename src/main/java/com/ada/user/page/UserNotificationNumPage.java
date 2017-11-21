package com.ada.user.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.user.entity.UserNotificationNum;
public class UserNotificationNumPage extends PageRpc<UserNotificationNum> {

	public UserNotificationNumPage(Pagination<UserNotificationNum> page) {
		super(page);
	}

}
