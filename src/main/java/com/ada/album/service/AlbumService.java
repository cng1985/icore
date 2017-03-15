package com.ada.album.service;

import com.ada.album.entity.Album;
import com.ada.album.page.AlbumPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


public interface AlbumService {

	public Album findById(String id);

	public Album save(Album bean);

	public Album update(Album bean);

	public Album deleteById(String id);
	
	public Album[] deleteByIds(String[] ids);
	
	public AlbumPage getPage(int pageNo, int pageSize);
	
	
	public Page<Album> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<Album> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}