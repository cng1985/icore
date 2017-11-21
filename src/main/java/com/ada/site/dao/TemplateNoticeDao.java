package com.ada.site.dao;


import  com.quhaodian.data.core.CriteriaDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import  com.ada.site.entity.TemplateNotice;

public interface TemplateNoticeDao extends CriteriaDao<TemplateNotice, String>{
	Pagination getPage(int pageNo, int pageSize);

	TemplateNotice findById(String id);

	TemplateNotice save(TemplateNotice bean);

	TemplateNotice updateByUpdater(Updater<TemplateNotice> updater);

	TemplateNotice deleteById(String id);
}