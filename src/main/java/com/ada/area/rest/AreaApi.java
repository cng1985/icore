package com.ada.area.rest;

import java.util.List;

import com.ada.area.dto.AreaDto;

/**
 * 
 * 地区接口
 * 
 * @author 年高
 *
 */
public interface AreaApi {

	/**
	 * 根据父id查找他的子节点
	 * 
	 * @param id
	 *            父id
	 * @return 地区集合
	 */
	List<AreaDto> findByPid(Integer id);

	/**
	 * 查找某个层级的数据
	 * 
	 * @param level
	 *            层级
	 * @return 地区集合
	 */
	List<AreaDto> findByLevel(Integer level);

	/**
	 * 根据id查询他下级所有的节点不包括自己
	 * 
	 * @param id
	 * @return
	 */
	List<AreaDto> childs(Integer id);

}
