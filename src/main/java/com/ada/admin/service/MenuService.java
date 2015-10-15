package com.ada.admin.service;

import java.util.List;

import com.ada.data.core.Pagination;
import com.ada.admin.entity.Menu;


public interface MenuService {
	public Pagination getPage(int pageNo, int pageSize);

	public Menu findById(Integer id);

	public Menu save(Menu bean);

	public Menu update(Menu bean);

	public Menu deleteById(Integer id);
	
	public Menu[] deleteByIds(Integer[] ids);
	
	public List<Menu> findChild(int id);
}