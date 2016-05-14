package com.ada.article.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Pagination;
import com.ada.article.dao.SensitiveCategoryDao;
import com.ada.article.entity.SensitiveCategory;

@Repository
public class SensitiveCategoryDaoImpl extends CriteriaDaoImpl<SensitiveCategory, Integer> implements SensitiveCategoryDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public SensitiveCategory findById(Integer id) {
	    if (id==null) {
			return null;
		}
		SensitiveCategory entity = get(id);
		return entity;
	}

	public SensitiveCategory save(SensitiveCategory bean) {
		getSession().save(bean);
		if (bean.getParentId() != null) {
			SensitiveCategory parent =findById(bean.getParentId());
			if (parent != null) {
				if (parent.getLevelinfo() != null) {
					bean.setLevelinfo(parent.getLevelinfo() + 1);
				} else {
					bean.setLevelinfo(2);
				}
				if (parent.getIds() != null) {
					bean.setIds(parent.getIds() + "," + bean.getId());

				} else {
					bean.setIds(parent.getId() + "," + bean.getId());
				}

			} else {
				bean.setLevelinfo(1);
				bean.setIds("" + bean.getId());
			}
		} else {
			bean.setLevelinfo(1);
			bean.setIds("" + bean.getId());
		}		
		
		
		return bean;
	}

	public SensitiveCategory deleteById(Integer id) {
		SensitiveCategory entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<SensitiveCategory> getEntityClass() {
		return SensitiveCategory.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}