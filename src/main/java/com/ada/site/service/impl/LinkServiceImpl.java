package com.ada.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Updater;
import com.ada.site.dao.LinkDao;
import com.ada.site.entity.Link;
import com.ada.site.service.LinkService;

import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.quhaodian.data.utils.FilterUtils;


/**
* Created by imake on 2017年06月07日16:23:50.
*/
@Service
@Transactional
public class LinkServiceImpl implements LinkService {

	private LinkDao dao;


	@Override
	@Transactional(readOnly = true)
	public Link findById(Long id) {
		return dao.findById(id);
	}


	@Override
    @Transactional
	public Link save(Link bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public Link update(Link bean) {
		Updater<Link> updater = new Updater<Link>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public Link deleteById(Long id) {
		Link bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public Link[] deleteByIds(Long[] ids) {
		Link[] beans = new Link[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(LinkDao dao) {
		this.dao = dao;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Link> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Override
    public Page<Link> page(Pageable pageable){
         return dao.page(pageable);
    }

	@Override
	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     return dao.count(filters);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Link> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
		return dao.findList(first,count,filters,orders);
	}

    @Override
	public Page<Link> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}
}