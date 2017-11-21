package com.ada.user.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.user.entity.UserMessage;
public class UserMessagePage extends PageRpc<UserMessage> {

	public UserMessagePage(Pagination<UserMessage> page) {
		super(page);
	}

}
