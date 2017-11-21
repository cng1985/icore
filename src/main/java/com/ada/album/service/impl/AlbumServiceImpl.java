package com.ada.album.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.ada.album.dao.AlbumDao;
import com.ada.album.entity.Album;
import com.ada.album.service.AlbumService;
import com.ada.album.page.AlbumPage;

import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
	

	@Transactional(readOnly = true)
	public Album findById(String id) {
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
	public Album deleteById(String id) {
		Album bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public Album[] deleteByIds(String[] ids) {
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
	
	
	@Transactional(readOnly = true)
	public Page<Album> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<Album> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
}