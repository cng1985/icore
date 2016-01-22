package com.ada.user.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.user.entity.UserNotificationMember;
public class UserNotificationMemberPage extends PageRpc<UserNotificationMember> {

	public UserNotificationMemberPage(Pagination<UserNotificationMember> page) {
		super(page);
	}

}
