package com.ada.site.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.site.entity.TemplatePush;

public interface TemplatePushDao extends CriteriaDao<TemplatePush, String>{
	public Pagination getPage(int pageNo, int pageSize);

	public TemplatePush findById(String id);

	public TemplatePush save(TemplatePush bean);

	public TemplatePush updateByUpdater(Updater<TemplatePush> updater);

	public TemplatePush deleteById(String id);
}