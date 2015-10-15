package com.ada.feed.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.BaseDaoImpl;
import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.feed.dao.FeedDao;
import com.ada.feed.entity.Feed;
import com.ada.feed.entity.FeedComment;
import com.ada.feed.page.FeedCommentPage;

@Repository
public class FeedDaoImpl extends BaseDaoImpl<Feed, Long> implements FeedDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public Feed findById(Long id) {
		Feed entity = get(id);
		return entity;
	}

	public Feed save(Feed bean) {
		getSession().save(bean);
		return bean;
	}

	public Feed deleteById(Long id) {
		Feed entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Feed> getEntityClass() {
		return Feed.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}

	
}