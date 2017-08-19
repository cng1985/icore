package com.ada.article.dao.impl;

import com.ada.data.core.Finder;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.article.dao.ArticleCatalogDao;
import com.ada.article.entity.ArticleCatalog;

import java.util.Date;


/**
* Created by imake on 2017年05月30日09:19:28.
*/
@Repository
public class ArticleCatalogDaoImpl extends CriteriaDaoImpl<ArticleCatalog, Integer> implements ArticleCatalogDao {

	@Override
	public ArticleCatalog findById(Integer id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public ArticleCatalog save(ArticleCatalog bean) {
		getSession().save(bean);
		if (bean.getParentId() != null) {
			ArticleCatalog parent =findById(bean.getParentId());
			if (parent != null) {
				if (parent.getLevelInfo() != null) {
					bean.setLevelInfo(parent.getLevelInfo() + 1);
				} else {
					bean.setLevelInfo(2);
				}
				if (parent.getIds() != null) {
					bean.setIds(parent.getIds() + "," + bean.getId());

				} else {
					bean.setIds(parent.getId() + "," + bean.getId());
				}

			} else {
				bean.setLevelInfo(1);
				bean.setIds("" + bean.getId());
			}
		} else {
			bean.setLevelInfo(1);
			bean.setIds("" + bean.getId());
		}		
		
		
		return bean;
	}

    @Override
	public ArticleCatalog deleteById(Integer id) {
		ArticleCatalog entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ArticleCatalog> getEntityClass() {
		return ArticleCatalog.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
	@Override
	public Integer updateNums(Integer id) {

		Integer result = 0;
		ArticleCatalog cur = findById(id);
		do {
			counts(cur);
			cur = cur.getParent();
			result++;
		} while (cur != null);

		return result;
	}

	private void counts(ArticleCatalog cur) {
		Finder finder = Finder.create();
		finder.append("from Article a where a.catalog.lft >= :lft ");
		finder.setParam("lft", cur.getLft());
		finder.append(" and a.catalog.rgt <= :rgt");
		finder.setParam("rgt", cur.getRgt());
		Long size = countQuery(finder);
		cur.setNums(size);
	}

	@Override
	public Integer updateNumsAndTime(Integer id) {
		Integer result = 0;
		ArticleCatalog cur = findById(id);
		if (cur == null) {
			return result;
		}
		do {
			counts(cur);
			cur.setLastDate(new Date());
			cur = cur.getParent();
			result++;
		} while (cur != null);

		return result;
	}

}