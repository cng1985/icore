package com.ada.feed.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.BaseDaoImpl;
import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.feed.dao.FeedCommentDao;
import com.ada.feed.entity.FeedComment;
import com.ada.feed.page.FeedCommentPage;

@Repository
public class FeedCommentDaoImpl extends BaseDaoImpl<FeedComment, Long> implements FeedCommentDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public FeedComment findById(Long id) {
		FeedComment entity = get(id);
		return entity;
	}

	public FeedComment save(FeedComment bean) {
		getSession().save(bean);
		return bean;
	}

	public FeedComment deleteById(Long id) {
		FeedComment entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<FeedComment> getEntityClass() {
		return FeedComment.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
	
	@Override
	public FeedCommentPage pageByFeed(long feedid, int pageNo, int pageSize) {
		FeedCommentPage result = null;
		Finder finder=Finder.create();
		finder.append("from FeedComment f where f.feed.id =:feedid");
		finder.setParam("feedid", feedid);
		finder.append(" order by f.id desc  ");
		Pagination<FeedComment> page =find(finder,pageNo, pageSize);
		result = new FeedCommentPage(page);
		return result;
	}
}