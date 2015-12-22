package com.ada.user.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.user.entity.UserVerification;
public class UserVerificationPage extends PageRpc<UserVerification> {

	public UserVerificationPage(Pagination<UserVerification> page) {
		super(page);
	}

}
