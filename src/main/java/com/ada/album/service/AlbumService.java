package com.ada.album.service;

import com.ada.album.entity.Album;
import com.ada.album.page.AlbumPage;


import com.openyelp.annotation.RestFul;

@RestFul(api=AlbumService.class,value="AlbumService")
public interface AlbumService {

	public Album findById(Long id);

	public Album save(Album bean);

	public Album update(Album bean);

	public Album deleteById(Long id);
	
	public Album[] deleteByIds(Long[] ids);
	
	public AlbumPage getPage(int pageNo, int pageSize);
	
}