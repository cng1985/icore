package com.ada.site.service;

import com.ada.site.entity.TemplateNotice;
import com.ada.site.page.TemplateNoticePage;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


public interface TemplateNoticeService {

	TemplateNotice findById(String id);

	TemplateNotice save(TemplateNotice bean);

	TemplateNotice update(TemplateNotice bean);

	TemplateNotice deleteById(String id);
	
	TemplateNotice[] deleteByIds(String[] ids);
	
	TemplateNoticePage getPage(int pageNo, int pageSize);
	
	
	Page<TemplateNotice> findPage(Pageable pageable);

	long count(Filter... filters);

	List<TemplateNotice> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}