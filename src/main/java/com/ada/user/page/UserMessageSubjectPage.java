package com.ada.user.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.user.entity.UserMessageSubject;
public class UserMessageSubjectPage extends PageRpc<UserMessageSubject> {

	public UserMessageSubjectPage(Pagination<UserMessageSubject> page) {
		super(page);
	}

}
