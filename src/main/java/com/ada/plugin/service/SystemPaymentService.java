package com.ada.plugin.service;

import com.ada.plugin.entity.SystemPayment;
import com.ada.plugin.page.SystemPaymentPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

import com.openyelp.annotation.RestFul;

@RestFul(api=SystemPaymentService.class,value="SystemPaymentService")
public interface SystemPaymentService {

	public SystemPayment findById(Long id);

	public SystemPayment save(SystemPayment bean);

	public SystemPayment update(SystemPayment bean);

	public SystemPayment deleteById(Long id);
	
	public SystemPayment[] deleteByIds(Long[] ids);
	
	public SystemPaymentPage getPage(int pageNo, int pageSize);
	
	
	public Page<SystemPayment> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<SystemPayment> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);

	public SystemPayment findBySn(String sn);
	
}