package com.ada.user.service;

import com.ada.user.entity.UserVerification;
import com.ada.user.page.UserVerificationPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

import com.openyelp.annotation.RestFul;

@RestFul(api=UserVerificationService.class,value="UserVerificationService")
public interface UserVerificationService {

	public UserVerification findById(Long id);

	public UserVerification save(UserVerification bean);

	public UserVerification update(UserVerification bean);

	public UserVerification deleteById(Long id);
	
	public UserVerification[] deleteByIds(Long[] ids);
	
	public UserVerificationPage getPage(int pageNo, int pageSize);
	
	
	public Page<UserVerification> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<UserVerification> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}