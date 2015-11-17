package com.ada.album.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.album.dao.AlbumDao;
import com.ada.album.entity.Album;
import com.ada.album.service.AlbumService;
import com.ada.album.page.AlbumPage;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
	

	@Transactional(readOnly = true)
	public Album findById(Long id) {
		Album entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public Album save(Album bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public Album update(Album bean) {
		Updater<Album> updater = new Updater<Album>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public Album deleteById(Long id) {
		Album bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public Album[] deleteByIds(Long[] ids) {
		Album[] beans = new Album[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private AlbumDao dao;

	@Autowired
	public void setDao(AlbumDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public AlbumPage getPage(int pageNo, int pageSize) {
	    AlbumPage result = null;
		Finder finder=Finder.create();
		finder.append("from Album f ");
		finder.append(" order by f.id desc  ");
		Pagination<Album> page = dao.find(finder,pageNo, pageSize);
		result = new AlbumPage(page);
		return result;
	}
}