package com.ada.site.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.site.entity.TemplatePush;

public interface TemplatePushDao extends CriteriaDao<TemplatePush, String>{
	Pagination getPage(int pageNo, int pageSize);

	TemplatePush findById(String id);

	TemplatePush save(TemplatePush bean);

	TemplatePush updateByUpdater(Updater<TemplatePush> updater);

	TemplatePush deleteById(String id);
}