package com.ada.question.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import com.ada.question.dao.QuestionCatalogDao;
import com.ada.question.dao.QuestionDao;
import com.ada.question.entity.Question;
import com.ada.question.page.QuestionPage;
import com.ada.question.service.QuestionService;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {
	@Transactional(readOnly = true)
	public QuestionPage getPage(int pageNo, int pageSize) {
		QuestionPage result = null;
		Finder finder = Finder.create();
		finder.append("from Question q");
		finder.append(" order by q.id desc ");
		Pagination<Question> page = dao.find(finder, pageNo, pageSize);
		result = new QuestionPage(page);
		return result;
	}

	@Transactional(readOnly = true)
	public Question findById(Long id) {
		Question entity = dao.findById(id);
		return entity;
	}

	@Autowired
	private QuestionCatalogDao catalogDao;

	@Transactional
	public Question save(Question bean) {
		bean.setAddDate(new Date());
		bean.setLastDate(new Date());
		dao.save(bean);
		Integer cid = -1;
		if (bean.getCatalog() != null) {
			cid = bean.getCatalog().getId();
		}
		if (cid > 0) {
			catalogDao.updateNumsAndTime(cid);
		}
		return bean;
	}

	@Transactional
	public Question update(Question bean) {

		bean.setLastDate(new Date());
		Updater<Question> updater = new Updater<Question>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public Question deleteById(Long id) {
		Question bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public Question[] deleteByIds(Long[] ids) {
		Question[] beans = new Question[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private QuestionDao dao;

	@Autowired
	public void setDao(QuestionDao dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	@Override
	public QuestionPage pageByCatalog(int catalog, int pageNo, int pageSize) {
		QuestionPage result = null;
		Finder finder = Finder.create();
		finder.append("from Question q where q.catalog.id=:cid ");
		finder.setParam("cid", catalog);
		finder.append(" order by q.id desc");
		Pagination<Question> page = dao.find(finder, pageNo, pageSize);
		result = new QuestionPage(page);
		return result;
	}

	@Transactional(readOnly = true)
	@Override
	public QuestionPage pageByUser(long uid, int pageNo, int pageSize) {
		QuestionPage result = null;
		Finder finder = Finder.create();
		finder.append("from Question q where q.user.id=:uid ");
		finder.setParam("uid", uid);
		finder.append(" order by q.id desc");
		Pagination<Question> page = dao.find(finder, pageNo, pageSize);
		result = new QuestionPage(page);
		return result;
	}

	@Transactional(readOnly = true)
	@Override
	public QuestionPage getPageByPid(Long id, int pageNo, int pageSize) {
		int ids = Integer.parseInt(id + "");
		QuestionPage result = null;
		Finder finder = Finder.create();
		finder.append("from Question q where q.catalog.id=:pid ");
		finder.setParam("pid", ids);
		finder.append(" order by q.id desc");
		Pagination<Question> page = dao.find(finder, pageNo, pageSize);
		result = new QuestionPage(page);
		return result;
	}

	@Transactional(readOnly = true)
	@Override
	public QuestionPage pageByType(String type, int pageNo, int pageSize) {
		QuestionPage result = null;
		Finder finder = Finder.create();
		finder.append("from Question q  ");
		if ("new".equals(type)) {
			finder.append(" order by q.id desc");
		} else if ("hot".equals(type)) {
			finder.append(" order by q.views desc");
		} else if ("vote".equals(type)) {
			finder.append(" order by q.votes desc");
		} else if ("answer".equals(type)) {
			finder.append(" order by q.answers desc");
		} else if ("views".equals(type)) {
			finder.append(" order by q.views desc");
		}else if ("unanswer".equals(type)) {
			finder.append(" where q.state != 1 order by q.id desc");
		} else {
			finder.append(" order by q.id desc");
		}
		Pagination<Question> page = dao.find(finder, pageNo, pageSize);
		result = new QuestionPage(page);
		return result;
	}
	@Transactional(readOnly = true)
	@Override
	public Page<Question> findPage(Pageable pageable) {
		return dao.findPage(pageable);
	}

}