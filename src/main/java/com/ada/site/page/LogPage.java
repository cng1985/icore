package com.ada.site.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.site.entity.Log;
public class LogPage extends PageRpc<Log> {

	public LogPage(Pagination<Log> page) {
		super(page);
	}

}
