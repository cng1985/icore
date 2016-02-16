package com.ada.approve.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.approve.entity.Flow;
public class FlowPage extends PageRpc<Flow> {

	public FlowPage(Pagination<Flow> page) {
		super(page);
	}

}
