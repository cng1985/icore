package com.ada.plugin.service;

import com.ada.plugin.entity.SystemPayment;
import com.ada.plugin.page.SystemPaymentPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface SystemPaymentService {

	SystemPayment findById(Long id);

	SystemPayment save(SystemPayment bean);

	SystemPayment update(SystemPayment bean);

	SystemPayment deleteById(Long id);
	
	SystemPayment[] deleteByIds(Long[] ids);
	
	SystemPaymentPage getPage(int pageNo, int pageSize);
	
	
	Page<SystemPayment> findPage(Pageable pageable);

	long count(Filter... filters);

	List<SystemPayment> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);

	SystemPayment findBySn(String sn);
	
}