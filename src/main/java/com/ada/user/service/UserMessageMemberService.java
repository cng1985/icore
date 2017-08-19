package com.ada.user.service;

import com.ada.user.entity.UserMessageMember;
import com.ada.user.page.UserMessageMemberPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface UserMessageMemberService {

	UserMessageMember findById(Long id);

	UserMessageMember save(UserMessageMember bean);

	UserMessageMember update(UserMessageMember bean);

	UserMessageMember deleteById(Long id);
	
	UserMessageMember[] deleteByIds(Long[] ids);
	
	UserMessageMemberPage getPage(int pageNo, int pageSize);
	
	
	Page<UserMessageMember> findPage(Pageable pageable);

	long count(Filter... filters);

	List<UserMessageMember> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}