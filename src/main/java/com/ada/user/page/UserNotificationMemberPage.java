package com.ada.user.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.user.entity.UserNotificationMember;
public class UserNotificationMemberPage extends PageRpc<UserNotificationMember> {

	public UserNotificationMemberPage(Pagination<UserNotificationMember> page) {
		super(page);
	}

}
