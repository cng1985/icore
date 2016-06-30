package com.ada.site.dao;


import java.util.Map;

import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.site.entity.WebTemplate;

public interface WebTemplateDao extends CriteriaDao<WebTemplate,String>{
	public Pagination getPage(int pageNo, int pageSize);

	public WebTemplate findById(String id);

	public WebTemplate save(WebTemplate bean);

	public WebTemplate updateByUpdater(Updater<WebTemplate> updater);

	public WebTemplate deleteById(String id);
	
	public String text(String templateid, Map<String, Object> keys);
}