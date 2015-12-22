package com.ada.area.service;

import java.util.List;

import com.ada.area.entity.Area;
import com.ada.area.page.AreaPage;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import com.openyelp.annotation.RestFul;

@RestFul(api=AreaService.class,value="AreaService")
public interface AreaService {

	public Area findById(Integer id);

	public Area save(Area bean);

	public Area update(Area bean);

	public Area deleteById(Integer id);
	
	public Area[] deleteByIds(Integer[] ids);
	
	public AreaPage getPage(int pageNo, int pageSize);
	
	public Area findByName(String name);
	public Area findByNames(String name);

	public List<Area> findByLevel(Integer id);

	public List<Area> findByParent(Integer id);
	public List<Area> findByChild(Integer id);
	public List<Area> findByTops(Integer id);

	public List<Area> findByHot(Integer id);

	public Page<Area> findPage(Pageable pageable);
	
}