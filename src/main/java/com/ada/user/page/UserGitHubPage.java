package com.ada.user.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.user.entity.UserGitHub;
public class UserGitHubPage extends PageRpc<UserGitHub> {

	public UserGitHubPage(Pagination<UserGitHub> page) {
		super(page);
	}

}
