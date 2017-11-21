package com.ada.activity.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.activity.entity.Activity;
public class ActivityPage extends PageRpc<Activity> {

	public ActivityPage(Pagination<Activity> page) {
		super(page);
	}

}
