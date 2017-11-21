package com.ada.user.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.user.entity.UserFeedBack;
public class UserFeedBackPage extends PageRpc<UserFeedBack> {

	public UserFeedBackPage(Pagination<UserFeedBack> page) {
		super(page);
	}

}
