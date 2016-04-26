package com.ada.user.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.user.entity.UserOauthToken;
public class UserOauthTokenPage extends PageRpc<UserOauthToken> {

	public UserOauthTokenPage(Pagination<UserOauthToken> page) {
		super(page);
	}

}
