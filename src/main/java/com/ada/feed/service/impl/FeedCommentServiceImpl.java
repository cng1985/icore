package com.ada.feed.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.ada.feed.dao.FeedCommentDao;
import com.ada.feed.entity.FeedComment;
import com.ada.feed.page.FeedCommentPage;
import com.ada.feed.service.FeedCommentService;

@Service
@Transactional
public class FeedCommentServiceImpl implements FeedCommentService {

	@Transactional(readOnly = true)
	public FeedComment findById(Long id) {
		FeedComment entity = dao.findById(id);
		return entity;
	}

	@Transactional
	public FeedComment save(FeedComment bean) {
		bean.setAddDate(new Date());
		bean.setLastDate(new Date());
		dao.save(bean);
		return bean;
	}

	@Transactional
	public FeedComment update(FeedComment bean) {
		bean.setLastDate(new Date());
		Updater<FeedComment> updater = new Updater<FeedComment>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public FeedComment deleteById(Long id) {
		FeedComment bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public FeedComment[] deleteByIds(Long[] ids) {
		FeedComment[] beans = new FeedComment[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private FeedCommentDao dao;

	@Autowired
	public void setDao(FeedCommentDao dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	public FeedCommentPage getPage(int pageNo, int pageSize) {
		FeedCommentPage result = null;
		Finder finder = Finder.create();
		finder.append("from FeedComment f ");
		finder.append(" order by f.id desc  ");
		Pagination<FeedComment> page = dao.find(finder, pageNo, pageSize);
		result = new FeedCommentPage(page);
		return result;
	}

	@Transactional(readOnly = true)
	@Override
	public FeedCommentPage pageByFeed(long feedid, int pageNo, int pageSize) {
		FeedCommentPage result = null;
		Finder finder = Finder.create();
		finder.append("from FeedComment f where f.feed.id =:feedid");
		finder.setParam("feedid", feedid);
		finder.append(" order by f.id desc  ");
		Pagination<FeedComment> page = dao.find(finder, pageNo, pageSize);
		result = new FeedCommentPage(page);
		return result;
	}
}