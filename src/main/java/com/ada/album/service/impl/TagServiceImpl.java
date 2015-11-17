package com.ada.album.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.album.dao.TagDao;
import com.ada.album.entity.Tag;
import com.ada.album.service.TagService;
import com.ada.album.page.TagPage;

@Service
@Transactional
public class TagServiceImpl implements TagService {
	

	@Transactional(readOnly = true)
	public Tag findById(String id) {
		Tag entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public Tag save(Tag bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public Tag update(Tag bean) {
		Updater<Tag> updater = new Updater<Tag>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public Tag deleteById(String id) {
		Tag bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public Tag[] deleteByIds(String[] ids) {
		Tag[] beans = new Tag[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private TagDao dao;

	@Autowired
	public void setDao(TagDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public TagPage getPage(int pageNo, int pageSize) {
	    TagPage result = null;
		Finder finder=Finder.create();
		finder.append("from Tag f ");
		finder.append(" order by f.id desc  ");
		Pagination<Tag> page = dao.find(finder,pageNo, pageSize);
		result = new TagPage(page);
		return result;
	}
}