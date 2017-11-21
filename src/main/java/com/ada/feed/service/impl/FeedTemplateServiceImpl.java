package com.ada.feed.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.ada.feed.dao.FeedTemplateDao;
import com.ada.feed.entity.FeedTemplate;
import com.ada.feed.service.FeedTemplateService;
import com.ada.feed.page.FeedTemplatePage;

import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class FeedTemplateServiceImpl implements FeedTemplateService {
	

	@Transactional(readOnly = true)
	public FeedTemplate findById(String id) {
		FeedTemplate entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public FeedTemplate save(FeedTemplate bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public FeedTemplate update(FeedTemplate bean) {
		Updater<FeedTemplate> updater = new Updater<FeedTemplate>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public FeedTemplate deleteById(String id) {
		FeedTemplate bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public FeedTemplate[] deleteByIds(String[] ids) {
		FeedTemplate[] beans = new FeedTemplate[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private FeedTemplateDao dao;

	@Autowired
	public void setDao(FeedTemplateDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public FeedTemplatePage getPage(int pageNo, int pageSize) {
	    FeedTemplatePage result = null;
		Finder finder=Finder.create();
		finder.append("from FeedTemplate f ");
		finder.append(" order by f.id desc  ");
		Pagination<FeedTemplate> page = dao.find(finder,pageNo, pageSize);
		result = new FeedTemplatePage(page);
		return result;
	}
	
	
	@Transactional(readOnly = true)
	public Page<FeedTemplate> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<FeedTemplate> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
}