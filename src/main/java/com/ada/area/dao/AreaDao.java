package com.ada.area.dao;


import  com.ada.area.entity.Area;
import com.ada.data.core.CriteriaDao;
import com.ada.data.core.Pagination;
import  com.ada.data.core.Updater;

public interface AreaDao extends CriteriaDao<Area, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public Area findById(Integer id);

	public Area save(Area bean);

	public Area updateByUpdater(Updater<Area> updater);

	public Area deleteById(Integer id);
}