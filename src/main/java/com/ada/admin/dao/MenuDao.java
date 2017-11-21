package com.ada.admin.dao;


import com.ada.admin.entity.Menu;
import com.quhaodian.data.core.CriteriaDao;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;

public interface MenuDao extends CriteriaDao<Menu, Integer>{
	Pagination getPage(int pageNo, int pageSize);

	Menu findById(Integer id);

	Menu save(Menu bean);

	Menu updateByUpdater(Updater<Menu> updater);

	Menu deleteById(Integer id);

}