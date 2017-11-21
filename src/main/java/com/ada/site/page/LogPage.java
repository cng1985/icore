package com.ada.site.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.site.entity.Log;
public class LogPage extends PageRpc<Log> {

	public LogPage(Pagination<Log> page) {
		super(page);
	}

}
