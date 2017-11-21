package com.ada.area.dao;


import  com.ada.area.entity.Area;
import com.quhaodian.data.core.CriteriaDao;
import com.quhaodian.data.core.Pagination;
import  com.quhaodian.data.core.Updater;

public interface AreaDao extends CriteriaDao<Area, Integer>{
	Pagination getPage(int pageNo, int pageSize);

	Area findById(Integer id);

	Area save(Area bean);

	Area updateByUpdater(Updater<Area> updater);

	Area deleteById(Integer id);

	Area findByName(String area);
}