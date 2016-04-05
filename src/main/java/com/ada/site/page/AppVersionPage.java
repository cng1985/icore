package com.ada.site.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.site.entity.AppVersion;
public class AppVersionPage extends PageRpc<AppVersion> {

	public AppVersionPage(Pagination<AppVersion> page) {
		super(page);
	}

}
