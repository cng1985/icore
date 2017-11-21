package com.ada.question.service.impl;

import com.quhaodian.data.core.Finder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Updater;
import com.ada.question.dao.QuestionCatalogDao;
import com.ada.question.entity.QuestionCatalog;
import com.ada.question.service.QuestionCatalogService;

import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;
import java.util.LinkedList;
import com.quhaodian.data.utils.FilterUtils;


/**
* Created by imake on 2017年05月30日09:15:17.
*/
@Service
@Transactional
public class QuestionCatalogServiceImpl implements QuestionCatalogService {

	private QuestionCatalogDao dao;


	@Override
	@Transactional(readOnly = true)
	public QuestionCatalog findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<QuestionCatalog> findByTops(Integer pid) {
		LinkedList<QuestionCatalog> result = new LinkedList<QuestionCatalog>();
		QuestionCatalog catalog = dao.findById(pid);
	    if(catalog != null){
			while ( catalog != null && catalog.getParent() != null ) {
				result.addFirst(catalog);
				catalog = dao.findById(catalog.getParentId());
			}
			result.addFirst(catalog);
	    }
		return result;
	}

	@Override
    @Transactional
	public QuestionCatalog save(QuestionCatalog bean) {
		dao.save(bean);
		return bean;
	}

	@Override
    @Transactional
	public QuestionCatalog update(QuestionCatalog bean) {
		Updater<QuestionCatalog> updater = new Updater<QuestionCatalog>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
    @Transactional
	public QuestionCatalog deleteById(Integer id) {
		QuestionCatalog bean = dao.findById(id);
        dao.deleteById(id);
		return bean;
	}

	@Override
    @Transactional	
	public QuestionCatalog[] deleteByIds(Integer[] ids) {
		QuestionCatalog[] beans = new QuestionCatalog[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}


	@Autowired
	public void setDao(QuestionCatalogDao dao) {
		this.dao = dao;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<QuestionCatalog> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Override
    public Page<QuestionCatalog> page(Pageable pageable){
         return dao.page(pageable);
    }

	@Override
	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     return dao.count(filters);
	}

	@Override
	@Transactional(readOnly = true)
	public List<QuestionCatalog> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
		return dao.findList(first,count,filters,orders);
	}

    @Override
	public Page<QuestionCatalog> page(Pageable pageable, Object search) {
		List<Filter> filters=	FilterUtils.getFilters(search);
		if (filters!=null) {
			pageable.getFilters().addAll(filters);
		}
		return dao.page(pageable);
	}


	@Transactional
	@Override
	public List<QuestionCatalog> findChild(int pid) {
		Finder finder = Finder.create("from QuestionCatalog t where t.parent.id=" + pid);
		finder.append(" order by t.sortNum asc");
		finder.setCacheable(true);
		return dao.find(finder);
	}

	@Transactional
	@Override
	public List<QuestionCatalog> findTop(Integer id) {
		LinkedList<QuestionCatalog> catalogs = new LinkedList<QuestionCatalog>();
		QuestionCatalog catalog = dao.findById(id);
		while (catalog.getParent() != null && catalog.getId() > 0) {
			catalogs.addFirst(catalog);
			catalog = dao.findById(catalog.getParentId());
		}

		if (catalog != null && catalog.getId() != null) {
			catalogs.addFirst(catalog);
		}
		return catalogs;
	}

}