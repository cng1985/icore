package com.ada.user.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.user.entity.UserRole;
public class UserRolePage extends PageRpc<UserRole> {

	public UserRolePage(Pagination<UserRole> page) {
		super(page);
	}

}
