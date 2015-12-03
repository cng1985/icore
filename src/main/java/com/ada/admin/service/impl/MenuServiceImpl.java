package com.ada.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.admin.dao.MenuDao;
import com.ada.admin.entity.Menu;
import com.ada.admin.service.MenuService;
import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public Menu findById(Integer id) {
		Menu entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public Menu save(Menu bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public Menu update(Menu bean) {
		Updater<Menu> updater = new Updater<Menu>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public Menu deleteById(Integer id) {
		Menu bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public Menu[] deleteByIds(Integer[] ids) {
		Menu[] beans = new Menu[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private MenuDao dao;

	@Autowired
	public void setDao(MenuDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Menu> findChild(int id) {
		Finder finder = Finder.create("from Menu t where t.parent.id=" + id);
		finder.append(" order by t.sortnum asc");
		finder.setCacheable(true);
		List ms=	dao.find(finder);
		return ms;
	}
}