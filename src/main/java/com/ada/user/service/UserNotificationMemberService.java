package com.ada.user.service;

import com.ada.user.entity.UserNotificationMember;
import com.ada.user.page.UserNotificationMemberPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface UserNotificationMemberService {

	public UserNotificationMember findById(Long id);

	public UserNotificationMember save(UserNotificationMember bean);

	public UserNotificationMember update(UserNotificationMember bean);

	public UserNotificationMember deleteById(Long id);
	
	public UserNotificationMember[] deleteByIds(Long[] ids);
	
	public UserNotificationMemberPage getPage(int pageNo, int pageSize);
	
	
	public Page<UserNotificationMember> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<UserNotificationMember> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}