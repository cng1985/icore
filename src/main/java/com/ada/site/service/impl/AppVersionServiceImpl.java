package com.ada.site.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import com.ada.site.dao.AppDao;
import com.ada.site.dao.AppVersionDao;
import com.ada.site.entity.App;
import com.ada.site.entity.AppVersion;
import com.ada.site.page.AppVersionPage;
import com.ada.site.service.AppVersionService;

@Service
@Transactional
public class AppVersionServiceImpl implements AppVersionService {

	@Transactional(readOnly = true)
	public AppVersion findById(Long id) {
		AppVersion entity = dao.findById(id);
		return entity;
	}

	@Autowired
	AppDao appDao;

	@Transactional
	public AppVersion save(AppVersion bean) {

		dao.save(bean);
		if (bean.getApp() != null) {
			App app = appDao.findById(bean.getApp().getId());
		}

		return bean;
	}

	@Transactional
	public AppVersion update(AppVersion bean) {
		Updater<AppVersion> updater = new Updater<AppVersion>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public AppVersion deleteById(Long id) {
		AppVersion bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public AppVersion[] deleteByIds(Long[] ids) {
		AppVersion[] beans = new AppVersion[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private AppVersionDao dao;

	@Autowired
	public void setDao(AppVersionDao dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	public AppVersionPage getPage(int pageNo, int pageSize) {
		AppVersionPage result = null;
		Finder finder = Finder.create();
		finder.append("from AppVersion f ");
		finder.append(" order by f.id desc  ");
		Pagination<AppVersion> page = dao.find(finder, pageNo, pageSize);
		result = new AppVersionPage(page);
		return result;
	}

	@Transactional(readOnly = true)
	public Page<AppVersion> findPage(Pageable pageable) {
		return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters) {

		return dao.count(filters);

	}

	@Transactional(readOnly = true)
	public List<AppVersion> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders) {

		return dao.findList(first, count, filters, orders);

	}
}