package com.ada.user.service;

import com.ada.user.entity.UserDevice;
import com.ada.user.page.UserDevicePage;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;

public interface UserDeviceService {

	UserDevice findById(Long id);

	UserDevice save(UserDevice bean);

	UserDevice update(UserDevice bean);

	UserDevice deleteById(Long id);
	
	UserDevice[] deleteByIds(Long[] ids);
	
	UserDevicePage getPage(int pageNo, int pageSize);
	
	
	Page<UserDevice> findPage(Pageable pageable);

	long count(Filter... filters);

	List<UserDevice> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}