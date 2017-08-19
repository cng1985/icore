package com.ada.site.dao;


import java.util.Map;

import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.site.entity.WebTemplate;

public interface WebTemplateDao extends CriteriaDao<WebTemplate,String>{
	Pagination getPage(int pageNo, int pageSize);

	WebTemplate findById(String id);

	WebTemplate save(WebTemplate bean);

	WebTemplate updateByUpdater(Updater<WebTemplate> updater);

	WebTemplate deleteById(String id);
	
	String text(String templateid, Map<String, Object> keys);
}