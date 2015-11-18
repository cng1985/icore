package com.ada.album.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.album.dao.PhotoDao;
import com.ada.album.entity.Photo;
import com.ada.album.service.PhotoService;
import com.ada.album.page.PhotoPage;

@Service
@Transactional
public class PhotoServiceImpl implements PhotoService {
	

	@Transactional(readOnly = true)
	public Photo findById(String id) {
		Photo entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public Photo save(Photo bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public Photo update(Photo bean) {
		Updater<Photo> updater = new Updater<Photo>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public Photo deleteById(String id) {
		Photo bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public Photo[] deleteByIds(String[] ids) {
		Photo[] beans = new Photo[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private PhotoDao dao;

	@Autowired
	public void setDao(PhotoDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public PhotoPage getPage(int pageNo, int pageSize) {
	    PhotoPage result = null;
		Finder finder=Finder.create();
		finder.append("from Photo f ");
		finder.append(" order by f.id desc  ");
		Pagination<Photo> page = dao.find(finder,pageNo, pageSize);
		result = new PhotoPage(page);
		return result;
	}
}