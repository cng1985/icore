package com.ada.album.service;

import com.ada.album.entity.Photo;
import com.ada.album.page.PhotoPage;


import com.openyelp.annotation.RestFul;

@RestFul(api=PhotoService.class,value="PhotoService")
public interface PhotoService {

	public Photo findById(Long id);

	public Photo save(Photo bean);

	public Photo update(Photo bean);

	public Photo deleteById(Long id);
	
	public Photo[] deleteByIds(Long[] ids);
	
	public PhotoPage getPage(int pageNo, int pageSize);
	
}