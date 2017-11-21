package com.ada.plugin.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.plugin.entity.SystemPayment;
public class SystemPaymentPage extends PageRpc<SystemPayment> {

	public SystemPaymentPage(Pagination<SystemPayment> page) {
		super(page);
	}

}
