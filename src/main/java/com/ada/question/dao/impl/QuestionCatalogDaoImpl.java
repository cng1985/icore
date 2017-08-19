package com.ada.question.dao.impl;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Finder;
import com.ada.question.dao.QuestionCatalogDao;
import com.ada.question.entity.QuestionCatalog;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;


/**
* Created by imake on 2017年05月30日09:15:17.
*/
@Repository
public class QuestionCatalogDaoImpl extends CriteriaDaoImpl<QuestionCatalog, Integer> implements QuestionCatalogDao {

	@Override
	public QuestionCatalog findById(Integer id) {
	    if (id==null) {
			return null;
		}
		return get(id);
	}

	@Override
	public QuestionCatalog save(QuestionCatalog bean) {
		getSession().save(bean);
		if (bean.getParentId() != null) {
			QuestionCatalog parent =findById(bean.getParentId());
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
	public QuestionCatalog deleteById(Integer id) {
		QuestionCatalog entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<QuestionCatalog> getEntityClass() {
		return QuestionCatalog.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}

	@Override
	public Integer updateNums(Integer id) {

		Integer result = 0;
		QuestionCatalog cur = findById(id);
		do {
			counts(cur);
			cur = cur.getParent();
			result++;
		} while (cur != null);

		return result;
	}

	private void counts(QuestionCatalog cur) {
		Finder finder = Finder.create();
		finder.append("from Question a where a.catalog.lft >= :lft ");
		finder.setParam("lft", cur.getLft());
		finder.append(" and a.catalog.rgt <= :rgt");
		finder.setParam("rgt", cur.getRgt());
		Long size = countQuery(finder);
		cur.setNums(size);
	}

	@Override
	public Integer updateNumsAndTime(Integer id) {
		Integer result = 0;
		QuestionCatalog cur = findById(id);
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