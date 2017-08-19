package com.ada.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Updater;
import com.ada.site.dao.LinkTypeDao;
import com.ada.site.entity.LinkType;
import com.ada.site.service.LinkTypeService;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.ada.data.utils.FilterUtils;


/**
* Created by imake on 2017年06月07日16:23:50.
*/
@Service
@Transactional
public class LinkTypeServiceImpl implements LinkTypeService {

	private LinkTypeDao dao;


	@Override
	@Transactional(readOnly = true)
	public LinkType findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<LinkType> findByTops(Integer pid) {
		LinkedList<LinkType> result = new LinkedList<LinkType>();
		LinkType catalog = dao.findById(pid);
	    if(catalog != null){
			while ( catalog != null && catalog.getParent() != null ) {
				result.addFirst(catalog);
				catalog = dao.findById(catalog.getParentId());
			}
			result.addFirst(catalog);
	    }else {
			LinkType type=new LinkType();
			type.setName("链接分类");
			dao.save(type);
			result.addFirst(type);

		}
		return result;
	}

	@Override
    @Transactional
	public LinkType save(LinkType bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public LinkType update(LinkType bean) {
		Updater<LinkType> updater = new Updater<LinkType>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public LinkType deleteById(Integer id) {
		LinkType bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public LinkType[] deleteByIds(Integer[] ids) {
		LinkType[] beans = new LinkType[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(LinkTypeDao dao) {
		this.dao = dao;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<LinkType> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Override
    public Page<LinkType> page(Pageable pageable){
         return dao.page(pageable);
    }

	@Override
	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     return dao.count(filters);
	}

	@Override
	@Transactional(readOnly = true)
	public List<LinkType> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
		return dao.findList(first,count,filters,orders);
	}

    @Override
	public Page<LinkType> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}
}