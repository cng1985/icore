package com.ada.plugin.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.plugin.entity.Payment;
public class PaymentPage extends PageRpc<Payment> {

	public PaymentPage(Pagination<Payment> page) {
		super(page);
	}

}
