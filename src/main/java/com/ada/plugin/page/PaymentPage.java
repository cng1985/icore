package com.ada.plugin.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.plugin.entity.SystemPayment;
public class PaymentPage extends PageRpc<SystemPayment> {

	public PaymentPage(Pagination<SystemPayment> page) {
		super(page);
	}

}