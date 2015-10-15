package com.ada.admin.dao;


import com.ada.admin.entity.Menu;
import com.ada.data.core.BaseDao;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;

public interface MenuDao extends BaseDao<Menu, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public Menu findById(Integer id);

	public Menu save(Menu bean);

	public Menu updateByUpdater(Updater<Menu> updater);

	public Menu deleteById(Integer id);

}