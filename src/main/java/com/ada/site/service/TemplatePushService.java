package com.ada.site.service;

import com.ada.site.entity.TemplatePush;
import com.ada.site.page.TemplatePushPage;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


public interface TemplatePushService {

	TemplatePush findById(String id);

	TemplatePush save(TemplatePush bean);

	TemplatePush update(TemplatePush bean);

	TemplatePush deleteById(String id);
	
	TemplatePush[] deleteByIds(String[] ids);
	
	TemplatePushPage getPage(int pageNo, int pageSize);
	
	
	Page<TemplatePush> findPage(Pageable pageable);

	long count(Filter... filters);

	List<TemplatePush> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}