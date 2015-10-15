package com.ada.area.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.area.entity.Area;

public interface AreaDao extends BaseDao<Area, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public Area findById(Integer id);

	public Area save(Area bean);

	public Area updateByUpdater(Updater<Area> updater);

	public Area deleteById(Integer id);
}