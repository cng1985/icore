package com.ada.album.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.ada.album.dao.PhotoFeedDao;
import com.ada.album.entity.PhotoFeed;
import com.ada.album.service.PhotoFeedService;
import com.ada.album.page.PhotoFeedPage;

import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class PhotoFeedServiceImpl implements PhotoFeedService {
	

	@Transactional(readOnly = true)
	public PhotoFeed findById(String id) {
		PhotoFeed entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public PhotoFeed save(PhotoFeed bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public PhotoFeed update(PhotoFeed bean) {
		Updater<PhotoFeed> updater = new Updater<PhotoFeed>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public PhotoFeed deleteById(String id) {
		PhotoFeed bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public PhotoFeed[] deleteByIds(String[] ids) {
		PhotoFeed[] beans = new PhotoFeed[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private PhotoFeedDao dao;

	@Autowired
	public void setDao(PhotoFeedDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public PhotoFeedPage getPage(int pageNo, int pageSize) {
	    PhotoFeedPage result = null;
		Finder finder=Finder.create();
		finder.append("from PhotoFeed f ");
		finder.append(" order by f.id desc  ");
		Pagination<PhotoFeed> page = dao.find(finder,pageNo, pageSize);
		result = new PhotoFeedPage(page);
		return result;
	}
	
	
	@Transactional(readOnly = true)
	public Page<PhotoFeed> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<PhotoFeed> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
}