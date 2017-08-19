package com.ada.album.service;

import com.ada.album.entity.Photo;
import com.ada.album.page.PhotoPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface PhotoService {

	Photo findById(String id);

	Photo save(Photo bean);

	Photo update(Photo bean);

	Photo deleteById(String id);
	
	Photo[] deleteByIds(String[] ids);
	
	PhotoPage getPage(int pageNo, int pageSize);
	
	
	Page<Photo> findPage(Pageable pageable);

	long count(Filter... filters);

	List<Photo> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);

	PhotoPage pageByCatalog(String id, int curpage, int pagesize);
	
}