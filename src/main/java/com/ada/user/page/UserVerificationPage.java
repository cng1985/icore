package com.ada.user.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.user.entity.UserVerification;
public class UserVerificationPage extends PageRpc<UserVerification> {

	public UserVerificationPage(Pagination<UserVerification> page) {
		super(page);
	}

}
