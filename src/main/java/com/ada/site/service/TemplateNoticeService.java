package com.ada.site.service;

import com.ada.site.entity.TemplateNotice;
import com.ada.site.page.TemplateNoticePage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

import com.openyelp.annotation.RestFul;

@RestFul(api=TemplateNoticeService.class,value="TemplateNoticeService")
public interface TemplateNoticeService {

	public TemplateNotice findById(String id);

	public TemplateNotice save(TemplateNotice bean);

	public TemplateNotice update(TemplateNotice bean);

	public TemplateNotice deleteById(String id);
	
	public TemplateNotice[] deleteByIds(String[] ids);
	
	public TemplateNoticePage getPage(int pageNo, int pageSize);
	
	
	public Page<TemplateNotice> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<TemplateNotice> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}