package com.ada.area.service;

import java.util.List;

import com.ada.admin.entity.Menu;
import com.ada.area.entity.Area;
import com.ada.area.page.AreaPage;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;

public interface AreaService {

	Area findById(Integer id);

	Area save(Area bean);

	Area update(Area bean);

	Area deleteById(Integer id);
	
	Area[] deleteByIds(Integer[] ids);
	
	AreaPage getPage(int pageNo, int pageSize);
	
	Area findByName(String name);
	Area findByNames(String name);

	List<Area> findByLevel(Integer id);

	List<Area> findByParent(Integer id);
	List<Area> findByChild(Integer id);
	List<Area> findByTops(Integer id);

	List<Area> findByHot(Integer id);

	Page<Area> page(Pageable pageable);

	Page<Area> findPage(Pageable pageable);
	List<Area> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);

	List<Area> findByPids();

	AreaPage pageByLevel(int level, int pageNo, int pageSize);
	
	
	/**

	 * 

	 * @param areaid

	 * @param level

	 * @param pageNo

	 * @param pageSize

	 * @return

	 */
	AreaPage pageByLevel(Integer areaid, int level, int pageNo, int pageSize);
	
	

	/**

	 * 查询某个状态下的城市

	 * @param level

	 * @param state

	 * @param pageNo

	 * @param pageSize

	 * @return

	 */
	AreaPage pageByLevelState(int level, int state, int pageNo, int pageSize);

	
}