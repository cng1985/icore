package com.ada.user.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.user.entity.UserDevice;
public class UserDevicePage extends PageRpc<UserDevice> {

	public UserDevicePage(Pagination<UserDevice> page) {
		super(page);
	}

}
