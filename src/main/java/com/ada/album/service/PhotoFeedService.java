package com.ada.album.service;

import com.ada.album.entity.PhotoFeed;
import com.ada.album.page.PhotoFeedPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface PhotoFeedService {

	public PhotoFeed findById(String id);

	public PhotoFeed save(PhotoFeed bean);

	public PhotoFeed update(PhotoFeed bean);

	public PhotoFeed deleteById(String id);
	
	public PhotoFeed[] deleteByIds(String[] ids);
	
	public PhotoFeedPage getPage(int pageNo, int pageSize);
	
	
	public Page<PhotoFeed> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<PhotoFeed> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}