package com.ada.article.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.article.dao.ArticleTagDao;
import com.ada.article.entity.ArticleTag;
import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Pagination;

@Repository
public class ArticleTagDaoImpl extends CriteriaDaoImpl<ArticleTag, Long> implements ArticleTagDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public ArticleTag findById(Long id) {
		ArticleTag entity = get(id);
		return entity;
	}

	public ArticleTag save(ArticleTag bean) {
		getSession().save(bean);
		return bean;
	}

	public ArticleTag deleteById(Long id) {
		ArticleTag entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	protected Class<ArticleTag> getEntityClass() {
		return ArticleTag.class;
	}

	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public ArticleTag tag(String tag) {
		ArticleTag result = null;
		List<ArticleTag> ts = findByProperty("name", tag);
		if (ts!=null&&ts.size()>0) {
			result=ts.get(0);
		}else{
			result=new ArticleTag();
			result.setName(tag);
			result.setSize(1);
			result=save(result);
		}
		return result;
	}
}