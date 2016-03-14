package com.ada.area.rest.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.area.dao.AreaDao;
import com.ada.area.dto.AreaDto;
import com.ada.area.entity.Area;
import com.ada.area.rest.AreaApi;



@Service
@Transactional
public class AreaWork implements AreaApi {

	@Autowired
	AreaDao areaDao;

	@Transactional(readOnly = true)
	@Override
	public List<AreaDto> findByPid(Integer id) {
		List<Area> areas = areaDao.findByProperty("parent.id", id);
        List<AreaDto> result = conver(areas);
		return result;
	}
	
	
	@Transactional(readOnly = true)
	@Override
	public List<AreaDto> findByLevel(Integer id) {
		
		List<Area> areas = areaDao.findByProperty("levelinfo", id);
		List<AreaDto> result = conver(areas);
		return result;
	}
	
	
	
	/**
	 * @param areas
	 * @return
	 */
	private List<AreaDto> conver(List<Area> areas) {
		List<AreaDto> result=new ArrayList<AreaDto>();
        if (areas!=null) {
			for (Area area : areas) {
				AreaDto dto=new AreaDto();
				dto.setId(area.getId());
				dto.setName(area.getName());
				result.add(dto);
			}
		}
		return result;
	}

}
