package com.ada.area.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.area.dao.AreaDao;
import com.ada.area.entity.Area;
import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Pagination;

@Repository
public class AreaDaoImpl extends CriteriaDaoImpl<Area, Integer> implements AreaDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public Area findById(Integer id) {
		Area entity = get(id);
		return entity;
	}

	public Area save(Area bean) {
		getSession().save(bean);
		if (bean.getParent() != null) {
			Area p = findById(bean.getParentId());
			Integer l = p.getLevelinfo();
			int level = 1;
			if (l != null) {
				level = l + 1;
			}
			bean.setLevelinfo(level);
		} else {
			bean.setLevelinfo(1);
		}
		return bean;
	}

	public Area deleteById(Integer id) {
		Area entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	protected Class<Area> getEntityClass() {
		return Area.class;
	}

	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}