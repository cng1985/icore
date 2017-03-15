package com.ada.user.service;

import com.ada.user.entity.UserMessageMember;
import com.ada.user.page.UserMessageMemberPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface UserMessageMemberService {

	public UserMessageMember findById(Long id);

	public UserMessageMember save(UserMessageMember bean);

	public UserMessageMember update(UserMessageMember bean);

	public UserMessageMember deleteById(Long id);
	
	public UserMessageMember[] deleteByIds(Long[] ids);
	
	public UserMessageMemberPage getPage(int pageNo, int pageSize);
	
	
	public Page<UserMessageMember> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<UserMessageMember> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}