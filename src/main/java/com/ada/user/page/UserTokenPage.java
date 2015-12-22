package com.ada.user.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.user.entity.UserToken;
public class UserTokenPage extends PageRpc<UserToken> {

	public UserTokenPage(Pagination<UserToken> page) {
		super(page);
	}

}
