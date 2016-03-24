package com.ada.site.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.site.entity.TemplateNotice;

public interface TemplateNoticeDao extends CriteriaDao<TemplateNotice, String>{
	public Pagination getPage(int pageNo, int pageSize);

	public TemplateNotice findById(String id);

	public TemplateNotice save(TemplateNotice bean);

	public TemplateNotice updateByUpdater(Updater<TemplateNotice> updater);

	public TemplateNotice deleteById(String id);
}