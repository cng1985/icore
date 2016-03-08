package com.ada.activity.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.activity.entity.Activity;
public class ActivityPage extends PageRpc<Activity> {

	public ActivityPage(Pagination<Activity> page) {
		super(page);
	}

}
