package com.ada.user.service;

import com.ada.user.entity.UserQQ;
import com.ada.user.entity.UserWeiXin;
import com.ada.user.page.UserWeiXinPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface UserWeiXinService {

	public UserWeiXin findById(Long id);

	public UserWeiXin save(UserWeiXin bean);

	public UserWeiXin update(UserWeiXin bean);

	public UserWeiXin deleteById(Long id);
	
	public UserWeiXin[] deleteByIds(Long[] ids);
	
	public UserWeiXinPage getPage(int pageNo, int pageSize);
	
	
	public Page<UserWeiXin> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<UserWeiXin> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
	public UserQQ login(String access_token, String openid)throws Exception ;

}