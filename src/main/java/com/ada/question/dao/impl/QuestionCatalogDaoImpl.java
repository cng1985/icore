package com.ada.question.dao.impl;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.question.dao.QuestionCatalogDao;
import com.ada.question.entity.QuestionCatalog;

@Repository
public class QuestionCatalogDaoImpl extends CriteriaDaoImpl<QuestionCatalog, Integer> implements QuestionCatalogDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public QuestionCatalog findById(Integer id) {
		if (id==null) {
			return null;
		}
		QuestionCatalog entity = get(id);
		return entity;
	}

	public QuestionCatalog save(QuestionCatalog bean) {
		getSession().save(bean);
		return bean;
	}

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