package com.ada.user.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.user.entity.UserToken;
public class UserTokenPage extends PageRpc<UserToken> {

	public UserTokenPage(Pagination<UserToken> page) {
		super(page);
	}

}
