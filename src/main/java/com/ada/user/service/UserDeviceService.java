package com.ada.user.service;

import com.ada.user.entity.UserDevice;
import com.ada.user.page.UserDevicePage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

import com.openyelp.annotation.RestFul;

@RestFul(api=UserDeviceService.class,value="UserDeviceService")
public interface UserDeviceService {

	public UserDevice findById(Long id);

	public UserDevice save(UserDevice bean);

	public UserDevice update(UserDevice bean);

	public UserDevice deleteById(Long id);
	
	public UserDevice[] deleteByIds(Long[] ids);
	
	public UserDevicePage getPage(int pageNo, int pageSize);
	
	
	public Page<UserDevice> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<UserDevice> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}