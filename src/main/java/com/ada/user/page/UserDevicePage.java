package com.ada.user.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.user.entity.UserDevice;
public class UserDevicePage extends PageRpc<UserDevice> {

	public UserDevicePage(Pagination<UserDevice> page) {
		super(page);
	}

}
