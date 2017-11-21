package com.ada.activity.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.activity.entity.ActivityCatalog;
public class ActivityCatalogPage extends PageRpc<ActivityCatalog> {

	public ActivityCatalogPage(Pagination<ActivityCatalog> page) {
		super(page);
	}

}
