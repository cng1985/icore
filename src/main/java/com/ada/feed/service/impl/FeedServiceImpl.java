package com.ada.feed.service.impl;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.ada.feed.dao.FeedCommentDao;
import com.ada.feed.dao.FeedDao;
import com.ada.feed.dao.FeedTemplateDao;
import com.ada.feed.dto.FeedDto;
import com.ada.feed.entity.Feed;
import com.ada.feed.entity.FeedTemplate;
import com.ada.feed.page.FeedDtoPage;
import com.ada.feed.page.FeedPage;
import com.ada.feed.service.FeedService;
import com.ada.user.entity.UserInfo;
import com.ada.user.entity.UserNotification;
import com.ada.user.entity.UserNotificationMember;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
@Transactional
public class FeedServiceImpl implements FeedService {

	@Transactional(readOnly = true)
	public Feed findById(Long id) {
		Feed entity = dao.findById(id);
		return entity;
	}

	@Transactional
	public Feed save(Feed bean) {
		bean.setAddDate(new Date());
		bean.setLastDate(new Date());
		bean.setComments(0);
		dao.save(bean);
		return bean;
	}

	@Transactional
	public Feed update(Feed bean) {
		bean.setLastDate(new Date());
		Updater<Feed> updater = new Updater<Feed>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public Feed deleteById(Long id) {
		Feed bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public Feed[] deleteByIds(Long[] ids) {
		Feed[] beans = new Feed[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private FeedDao dao;
	
	@Autowired
	private FeedTemplateDao feedTemplateDao;

	@Autowired
	public void setDao(FeedDao dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	public FeedPage getPage(int pageNo, int pageSize) {
		FeedPage result = null;
		Finder finder = Finder.create();
		finder.append("from Feed f ");
		finder.append(" order by f.id desc  ");
		Pagination<Feed> page = dao.find(finder, pageNo, pageSize);
		result = new FeedPage(page);
		return result;
	}
	
	@Autowired
	FeedCommentDao commentDao;

	@Transactional(readOnly = true)
	@Override
	public FeedDtoPage page(int pageNo, int pageSize) {
		FeedDtoPage result = new FeedDtoPage();
		Finder finder = Finder.create();
		finder.append("from Feed f ");
		finder.append(" order by f.id desc  ");
		Pagination<Feed> page = dao.find(finder, pageNo, pageSize);
		result.setPage(page);
		List<FeedDto> dtos = new ArrayList<FeedDto>();
		List<Feed> feeds = page.getList();
		if(feeds!=null){
			for (Feed feed : feeds) {
				FeedDto dto=new FeedDto();
				dto.setFeed(feed);
				dto.setCommentPage(commentDao.pageByFeed(feed.getId(), pageNo, pageSize));
				dtos.add(dto);
				
			}
			result.setList(dtos);
		}

		return result;
	}
	@Transactional
	@Override
	public Feed push(String templateid, Object object, Long userid) {
		Feed bean = new Feed();

		FeedTemplate f=	feedTemplateDao.findById(templateid);
		if (f!=null) {
			Configuration config = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
			try {
				Template template = new Template(f.getId(), f.getNote(), config);
				Writer out = new StringWriter();
				Map<String, Object> keys=new HashMap<String, Object>();
				keys.put("object", object);
				template.process(keys, out);
				String msg = out.toString();
				bean.setAddDate(new Date());
				bean.setLastDate(new Date());
				bean.setUser(UserInfo.fromId(userid));
				bean.setNote(msg);
				bean.setCatalog(f.getCatalog());
				dao.save(bean);
			} catch (TemplateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return bean;
	}
}