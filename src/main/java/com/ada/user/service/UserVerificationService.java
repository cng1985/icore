package com.ada.user.service;

import com.ada.user.entity.UserVerification;
import com.ada.user.page.UserVerificationPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface UserVerificationService {

	UserVerification findById(Long id);

	UserVerification save(UserVerification bean);

	UserVerification update(UserVerification bean);

	UserVerification deleteById(Long id);
	
	UserVerification[] deleteByIds(Long[] ids);
	
	UserVerificationPage getPage(int pageNo, int pageSize);
	
	
	Page<UserVerification> findPage(Pageable pageable);

	long count(Filter... filters);

	List<UserVerification> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}