package com.ada.album.service;

import com.ada.album.entity.Tag;
import com.ada.album.page.TagPage;


import com.openyelp.annotation.RestFul;

@RestFul(api=TagService.class,value="TagService")
public interface TagService {

	public Tag findById(String id);

	public Tag save(Tag bean);

	public Tag update(Tag bean);

	public Tag deleteById(String id);
	
	public Tag[] deleteByIds(String[] ids);
	
	public TagPage getPage(int pageNo, int pageSize);
	
}