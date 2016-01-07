package com.ada.user.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.user.entity.UserRole;
public class UserRolePage extends PageRpc<UserRole> {

	public UserRolePage(Pagination<UserRole> page) {
		super(page);
	}

}
