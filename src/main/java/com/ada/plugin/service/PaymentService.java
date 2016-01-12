package com.ada.plugin.service;

import com.ada.plugin.entity.Payment;
import com.ada.plugin.page.PaymentPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

import com.openyelp.annotation.RestFul;

@RestFul(api=PaymentService.class,value="PaymentService")
public interface PaymentService {

	public Payment findById(Long id);

	public Payment save(Payment bean);

	public Payment update(Payment bean);

	public Payment deleteById(Long id);
	
	public Payment[] deleteByIds(Long[] ids);
	
	public PaymentPage getPage(int pageNo, int pageSize);
	
	
	public Page<Payment> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<Payment> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);

	public Payment findBySn(String sn);
	
}