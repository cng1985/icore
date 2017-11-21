package com.ada.site.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.site.entity.App;
public class AppPage extends PageRpc<App> {

	public AppPage(Pagination<App> page) {
		super(page);
	}

}
