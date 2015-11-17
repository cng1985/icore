package com.ada.album.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.album.dao.PhotoFeedDao;
import com.ada.album.entity.PhotoFeed;
import com.ada.album.service.PhotoFeedService;
import com.ada.album.page.PhotoFeedPage;

@Service
@Transactional
public class PhotoFeedServiceImpl implements PhotoFeedService {
	

	@Transactional(readOnly = true)
	public PhotoFeed findById(Long id) {
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
	public PhotoFeed deleteById(Long id) {
		PhotoFeed bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public PhotoFeed[] deleteByIds(Long[] ids) {
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
}