package com.ada.area.rest;

import java.util.List;

import com.ada.area.dto.AreaDto;

public interface AreaApi {

	public List<AreaDto> findByPid(Integer id);
	
	 List<AreaDto> findByLevel(Integer id);
}