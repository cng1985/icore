package com.ada.approve.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.approve.entity.Flow;
public class FlowPage extends PageRpc<Flow> {

	public FlowPage(Pagination<Flow> page) {
		super(page);
	}

}
