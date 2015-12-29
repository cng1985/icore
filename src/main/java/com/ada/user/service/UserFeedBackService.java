package com.ada.user.service;

import com.ada.user.entity.UserFeedBack;
import com.ada.user.page.UserFeedBackPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

import com.openyelp.annotation.RestFul;

@RestFul(api=UserFeedBackService.class,value="UserFeedBackService")
public interface UserFeedBackService {

	public UserFeedBack findById(Long id);

	public UserFeedBack save(UserFeedBack bean);

	public UserFeedBack update(UserFeedBack bean);

	public UserFeedBack deleteById(Long id);
	
	public UserFeedBack[] deleteByIds(Long[] ids);
	
	public UserFeedBackPage getPage(int pageNo, int pageSize);
	
	
	public Page<UserFeedBack> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<UserFeedBack> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}