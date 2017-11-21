package com.ada.approve.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.approve.entity.FlowRecord;
public class FlowRecordPage extends PageRpc<FlowRecord> {

	public FlowRecordPage(Pagination<FlowRecord> page) {
		super(page);
	}

}
