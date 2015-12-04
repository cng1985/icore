package com.ada.plugin.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Pagination;
import com.ada.plugin.dao.PluginConfigDao;
import com.ada.plugin.entity.PluginConfig;

@Repository
public class PluginConfigDaoImpl extends CriteriaDaoImpl<PluginConfig, Long> implements PluginConfigDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public PluginConfig findById(Long id) {
		PluginConfig entity = get(id);
		return entity;
	}

	public PluginConfig save(PluginConfig bean) {
		getSession().save(bean);
		return bean;
	}

	public PluginConfig deleteById(Long id) {
		PluginConfig entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<PluginConfig> getEntityClass() {
		return PluginConfig.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}