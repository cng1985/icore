package com.ada.album.service;

import com.ada.album.entity.Album;
import com.ada.album.page.AlbumPage;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


public interface AlbumService {

	Album findById(String id);

	Album save(Album bean);

	Album update(Album bean);

	Album deleteById(String id);
	
	Album[] deleteByIds(String[] ids);
	
	AlbumPage getPage(int pageNo, int pageSize);
	
	
	Page<Album> findPage(Pageable pageable);

	long count(Filter... filters);

	List<Album> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}