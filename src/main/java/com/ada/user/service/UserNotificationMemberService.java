package com.ada.user.service;

import com.ada.user.entity.UserNotificationMember;
import com.ada.user.page.UserNotificationMemberPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

public interface UserNotificationMemberService {

	UserNotificationMember findById(Long id);

	UserNotificationMember save(UserNotificationMember bean);

	UserNotificationMember update(UserNotificationMember bean);

	UserNotificationMember deleteById(Long id);
	
	UserNotificationMember[] deleteByIds(Long[] ids);
	
	UserNotificationMemberPage getPage(int pageNo, int pageSize);
	
	
	Page<UserNotificationMember> findPage(Pageable pageable);

	long count(Filter... filters);

	List<UserNotificationMember> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}