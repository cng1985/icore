package com.ada.user.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.user.entity.UserMessageMember;
public class UserMessageMemberPage extends PageRpc<UserMessageMember> {

	public UserMessageMemberPage(Pagination<UserMessageMember> page) {
		super(page);
	}

}
