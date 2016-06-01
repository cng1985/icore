package com.ada.admin.service;

import java.util.List;

import com.ada.admin.entity.Menu;
import com.ada.data.core.Pagination;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;

public interface MenuService {
	public Pagination getPage(int pageNo, int pageSize);

	public Menu findById(Integer id);

	public Menu save(Menu bean);

	public Menu update(Menu bean);

	public Menu deleteById(Integer id);

	public Menu[] deleteByIds(Integer[] ids);

	public List<Menu> findChild(int id);

	public List<Menu> findTop(Integer id);
	
	
	public Page<Menu> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<Menu> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}