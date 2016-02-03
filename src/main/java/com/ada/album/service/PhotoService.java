package com.ada.album.service;

import com.ada.album.entity.Photo;
import com.ada.album.page.PhotoPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

import com.openyelp.annotation.RestFul;

@RestFul(api=PhotoService.class,value="PhotoService")
public interface PhotoService {

	public Photo findById(String id);

	public Photo save(Photo bean);

	public Photo update(Photo bean);

	public Photo deleteById(String id);
	
	public Photo[] deleteByIds(String[] ids);
	
	public PhotoPage getPage(int pageNo, int pageSize);
	
	
	public Page<Photo> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<Photo> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}