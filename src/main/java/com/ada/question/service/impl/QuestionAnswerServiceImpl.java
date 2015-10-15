package com.ada.question.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.question.dao.QuestionAnswerDao;
import com.ada.question.dao.QuestionDao;
import com.ada.question.entity.Question;
import com.ada.question.entity.QuestionAnswer;
import com.ada.question.service.QuestionAnswerService;
import com.ada.question.service.QuestionService;
import com.ada.question.page.QuestionAnswerPage;

@Service
@Transactional
public class QuestionAnswerServiceImpl implements QuestionAnswerService {
	@Transactional(readOnly = true)
	public QuestionAnswerPage getPage(int pageNo, int pageSize) {
		QuestionAnswerPage result = null;
		Pagination<QuestionAnswer> page = dao.getPage(pageNo, pageSize);
		result = new QuestionAnswerPage(page);
		return result;
	}

	@Autowired
	QuestionDao questionDao;

	@Transactional(readOnly = true)
	public QuestionAnswer findById(Long id) {
		QuestionAnswer entity = dao.findById(id);
		return entity;
	}

	@Transactional
	public QuestionAnswer save(QuestionAnswer bean) {
		QuestionAnswer result = new QuestionAnswer();
		result.setId(-1l);
		if (bean.getQuestion() == null || bean.getUser() == null) {
			return result;
		}
		bean.setAddDate(new Date());
		bean.setLastDate(new Date());
		bean.setUps(0);
		result = dao.save(bean);
		Question question = questionDao.findById(bean.getQuestion().getId());
		if (question != null) {
			Finder coutfinder = Finder.create();
			coutfinder.append("from QuestionAnswer q where q.question.id=:qid");
			coutfinder.setParam("qid", bean.getQuestion().getId());
			int size = dao.countQueryResult(coutfinder);
			question.setAnswers(size);
		}

		return result;
	}

	@Transactional
	public QuestionAnswer update(QuestionAnswer bean) {

		bean.setLastDate(new Date());
		Updater<QuestionAnswer> updater = new Updater<QuestionAnswer>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public QuestionAnswer deleteById(Long id) {
		QuestionAnswer bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public QuestionAnswer[] deleteByIds(Long[] ids) {
		QuestionAnswer[] beans = new QuestionAnswer[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private QuestionAnswerDao dao;

	@Autowired
	public void setDao(QuestionAnswerDao dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	@Override
	public QuestionAnswerPage pageByQuestion(long qid, int pageNo, int pageSize) {
		QuestionAnswerPage result = null;
		Finder finder = Finder.create();
		finder.append("from QuestionAnswer q where q.question.id=:qid ");
		finder.setParam("qid", qid);
		finder.append(" order by q.state desc, q.id desc");
		Pagination<QuestionAnswer> page = dao.find(finder, pageNo, pageSize);
		result = new QuestionAnswerPage(page);
		return result;
	}

	@Transactional
	@Override
	public QuestionAnswer answer(Long id) {
		QuestionAnswer a = dao.findById(id);
		if (a != null) {
			a.setState(1);
			a.setLastDate(new Date());
			Question q = questionDao.findById(a.getQuestion().getId());
			if (q != null) {
				q.setState(1);
			}
		}

		return a;
	}
}