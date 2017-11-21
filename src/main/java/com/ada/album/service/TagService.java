package com.ada.album.service;

import com.ada.album.entity.Tag;
import com.ada.album.page.TagPage;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


public interface TagService {

	Tag findById(String id);

	Tag save(Tag bean);

	Tag update(Tag bean);

	Tag deleteById(String id);
	
	Tag[] deleteByIds(String[] ids);
	
	TagPage getPage(int pageNo, int pageSize);
	
	
	Page<Tag> findPage(Pageable pageable);

	long count(Filter... filters);

	List<Tag> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}