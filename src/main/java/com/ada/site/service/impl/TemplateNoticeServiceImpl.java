package com.ada.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.ada.site.dao.TemplateNoticeDao;
import com.ada.site.entity.TemplateNotice;
import com.ada.site.service.TemplateNoticeService;
import com.ada.site.page.TemplateNoticePage;

import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class TemplateNoticeServiceImpl implements TemplateNoticeService {
	

	@Transactional(readOnly = true)
	public TemplateNotice findById(String id) {
		TemplateNotice entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public TemplateNotice save(TemplateNotice bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public TemplateNotice update(TemplateNotice bean) {
		Updater<TemplateNotice> updater = new Updater<TemplateNotice>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public TemplateNotice deleteById(String id) {
		TemplateNotice bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public TemplateNotice[] deleteByIds(String[] ids) {
		TemplateNotice[] beans = new TemplateNotice[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private TemplateNoticeDao dao;

	@Autowired
	public void setDao(TemplateNoticeDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public TemplateNoticePage getPage(int pageNo, int pageSize) {
	    TemplateNoticePage result = null;
		Finder finder=Finder.create();
		finder.append("from TemplateNotice f ");
		finder.append(" order by f.id desc  ");
		Pagination<TemplateNotice> page = dao.find(finder,pageNo, pageSize);
		result = new TemplateNoticePage(page);
		return result;
	}
	
	
	@Transactional(readOnly = true)
	public Page<TemplateNotice> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<TemplateNotice> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
}