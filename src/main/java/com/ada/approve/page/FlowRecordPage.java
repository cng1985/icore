package com.ada.approve.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.approve.entity.FlowRecord;
public class FlowRecordPage extends PageRpc<FlowRecord> {

	public FlowRecordPage(Pagination<FlowRecord> page) {
		super(page);
	}

}
