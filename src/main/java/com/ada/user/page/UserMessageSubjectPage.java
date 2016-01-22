package com.ada.user.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.user.entity.UserMessageSubject;
public class UserMessageSubjectPage extends PageRpc<UserMessageSubject> {

	public UserMessageSubjectPage(Pagination<UserMessageSubject> page) {
		super(page);
	}

}
