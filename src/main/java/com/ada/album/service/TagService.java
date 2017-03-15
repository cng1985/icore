package com.ada.album.service;

import com.ada.album.entity.Tag;
import com.ada.album.page.TagPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface TagService {

	public Tag findById(String id);

	public Tag save(Tag bean);

	public Tag update(Tag bean);

	public Tag deleteById(String id);
	
	public Tag[] deleteByIds(String[] ids);
	
	public TagPage getPage(int pageNo, int pageSize);
	
	
	public Page<Tag> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<Tag> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}