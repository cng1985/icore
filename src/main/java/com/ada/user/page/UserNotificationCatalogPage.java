package com.ada.user.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.user.entity.UserNotificationCatalog;
public class UserNotificationCatalogPage extends PageRpc<UserNotificationCatalog> {

	public UserNotificationCatalogPage(Pagination<UserNotificationCatalog> page) {
		super(page);
	}

}
