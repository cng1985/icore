package com.ada.site.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.site.entity.App;
public class AppPage extends PageRpc<App> {

	public AppPage(Pagination<App> page) {
		super(page);
	}

}
