package com.ada.album.service;

import com.ada.album.entity.PhotoFeed;
import com.ada.album.page.PhotoFeedPage;


import com.openyelp.annotation.RestFul;

@RestFul(api=PhotoFeedService.class,value="PhotoFeedService")
public interface PhotoFeedService {

	public PhotoFeed findById(Long id);

	public PhotoFeed save(PhotoFeed bean);

	public PhotoFeed update(PhotoFeed bean);

	public PhotoFeed deleteById(Long id);
	
	public PhotoFeed[] deleteByIds(Long[] ids);
	
	public PhotoFeedPage getPage(int pageNo, int pageSize);
	
}