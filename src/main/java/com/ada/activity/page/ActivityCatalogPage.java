package com.ada.activity.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.activity.entity.ActivityCatalog;
public class ActivityCatalogPage extends PageRpc<ActivityCatalog> {

	public ActivityCatalogPage(Pagination<ActivityCatalog> page) {
		super(page);
	}

}
