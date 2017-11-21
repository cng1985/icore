package com.ada.article.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.ada.article.dao.ArticleTagDao;
import com.ada.article.entity.ArticleTag;
import com.ada.article.service.ArticleTagService;
import com.ada.article.page.ArticleTagPage;

import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class ArticleTagServiceImpl implements ArticleTagService {
	

	@Transactional(readOnly = true)
	public ArticleTag findById(Long id) {
		ArticleTag entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public ArticleTag save(ArticleTag bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public ArticleTag update(ArticleTag bean) {
		Updater<ArticleTag> updater = new Updater<ArticleTag>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public ArticleTag deleteById(Long id) {
		ArticleTag bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public ArticleTag[] deleteByIds(Long[] ids) {
		ArticleTag[] beans = new ArticleTag[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private ArticleTagDao dao;

	@Autowired
	public void setDao(ArticleTagDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public ArticleTagPage getPage(int pageNo, int pageSize) {
	    ArticleTagPage result = null;
		Finder finder=Finder.create();
		finder.append("from ArticleTag f ");
		finder.append(" order by f.id desc  ");
		Pagination<ArticleTag> page = dao.find(finder,pageNo, pageSize);
		result = new ArticleTagPage(page);
		return result;
	}
	
	
	public Page<ArticleTag> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	public List<ArticleTag> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
}