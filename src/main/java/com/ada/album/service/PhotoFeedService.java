package com.ada.album.service;

import com.ada.album.entity.PhotoFeed;
import com.ada.album.page.PhotoFeedPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface PhotoFeedService {

	PhotoFeed findById(String id);

	PhotoFeed save(PhotoFeed bean);

	PhotoFeed update(PhotoFeed bean);

	PhotoFeed deleteById(String id);
	
	PhotoFeed[] deleteByIds(String[] ids);
	
	PhotoFeedPage getPage(int pageNo, int pageSize);
	
	
	Page<PhotoFeed> findPage(Pageable pageable);

	long count(Filter... filters);

	List<PhotoFeed> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}