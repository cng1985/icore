package com.ada.plugin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.plugin.dao.PluginConfigDao;
import com.ada.plugin.entity.PluginConfig;
import com.ada.plugin.service.PluginConfigService;
import com.ada.plugin.page.PluginConfigPage;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

@Service
@Transactional
public class PluginConfigServiceImpl implements PluginConfigService {

	@Transactional(readOnly = true)
	public PluginConfig findById(Long id) {
		PluginConfig entity = dao.findById(id);
		return entity;
	}

	@Transactional
	public PluginConfig save(PluginConfig bean) {
		dao.save(bean);
		return bean;
	}

	@Transactional
	public PluginConfig update(PluginConfig bean) {
		Updater<PluginConfig> updater = new Updater<PluginConfig>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public PluginConfig deleteById(Long id) {
		PluginConfig bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public PluginConfig[] deleteByIds(Long[] ids) {
		PluginConfig[] beans = new PluginConfig[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private PluginConfigDao dao;

	@Autowired
	public void setDao(PluginConfigDao dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	public PluginConfigPage getPage(int pageNo, int pageSize) {
		PluginConfigPage result = null;
		Finder finder = Finder.create();
		finder.append("from PluginConfig f ");
		finder.append(" order by f.id desc  ");
		Pagination<PluginConfig> page = dao.find(finder, pageNo, pageSize);
		result = new PluginConfigPage(page);
		return result;
	}

	public Page<PluginConfig> findPage(Pageable pageable) {
		return dao.findPage(pageable);
	}

	public long count(Filter... filters) {

		return dao.count(filters);

	}

	public List<PluginConfig> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders) {

		return dao.findList(first, count, filters, orders);

	}

	@Override
	public boolean pluginIdExists(String id) {
		Long count = dao.count(Filter.eq("pluginId", id));
		return count > 0;
	}

	@Override
	public PluginConfig findByPluginId(String id) {
		List<PluginConfig> plugs = dao.findByProperty("pluginId", id);
		if (plugs != null && plugs.size() > 0) {
			return plugs.get(0);

		} else {
			return null;
		}
	}
}