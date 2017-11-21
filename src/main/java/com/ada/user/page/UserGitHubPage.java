package com.ada.user.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.user.entity.UserGitHub;
public class UserGitHubPage extends PageRpc<UserGitHub> {

	public UserGitHubPage(Pagination<UserGitHub> page) {
		super(page);
	}

}
