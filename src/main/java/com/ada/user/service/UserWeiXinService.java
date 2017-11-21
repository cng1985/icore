package com.ada.user.service;

import com.ada.user.entity.UserQQ;
import com.ada.user.entity.UserWeiXin;
import com.ada.user.page.UserWeiXinPage;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


public interface UserWeiXinService {

	UserWeiXin findById(Long id);

	UserWeiXin save(UserWeiXin bean);

	UserWeiXin update(UserWeiXin bean);

	UserWeiXin deleteById(Long id);
	
	UserWeiXin[] deleteByIds(Long[] ids);
	
	UserWeiXinPage getPage(int pageNo, int pageSize);
	
	
	Page<UserWeiXin> findPage(Pageable pageable);

	long count(Filter... filters);

	List<UserWeiXin> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
	UserQQ login(String access_token, String openid)throws Exception ;

}