package com.ada.question.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.ada.question.dao.QuestionDao;
import com.ada.question.dao.QuestionFavoriteDao;
import com.ada.question.entity.Question;
import com.ada.question.entity.QuestionAnswer;
import com.ada.question.entity.QuestionFavorite;
import com.ada.question.entity.QuestionVote;
import com.ada.question.service.QuestionFavoriteService;
import com.ada.question.page.QuestionFavoritePage;

@Service
@Transactional
public class QuestionFavoriteServiceImpl implements QuestionFavoriteService {

	@Transactional(readOnly = true)
	public QuestionFavorite findById(Long id) {
		QuestionFavorite entity = dao.findById(id);
		return entity;
	}

	@Autowired
	QuestionDao questionDao;

	@Transactional
	public QuestionFavorite save(QuestionFavorite bean) {
		QuestionFavorite vote = new QuestionFavorite();
		vote.setId(-1l);
		if (bean.getQuestion() == null || bean.getUser() == null) {
			return vote;
		}
		Finder finder = Finder.create();
		finder.append("from QuestionFavorite q where q.user.id = :uid ");
		finder.setParam("uid", bean.getUser().getId());
		finder.append(" and q.question.id = :questionid");
		finder.setParam("questionid", bean.getQuestion().getId());
		List<QuestionFavorite> vs = dao.find(finder);
		if (vs != null && vs.size() > 0) {
			vote = vs.get(0);
		} else {
			vote = dao.save(bean);
		}
		Finder coutfinder = Finder.create();
		coutfinder.append("from QuestionFavorite q where q.question.id=:aid");
		coutfinder.setParam("aid", bean.getQuestion().getId());
		int size = dao.countQueryResult(coutfinder);
		Question answer = questionDao.findById(bean.getQuestion().getId());
		if (answer != null) {
			answer.setFavorites(size);
		}
		return vote;
	}

	@Transactional
	public QuestionFavorite update(QuestionFavorite bean) {
		Updater<QuestionFavorite> updater = new Updater<QuestionFavorite>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public QuestionFavorite deleteById(Long id) {
		QuestionFavorite bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public QuestionFavorite[] deleteByIds(Long[] ids) {
		QuestionFavorite[] beans = new QuestionFavorite[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private QuestionFavoriteDao dao;

	@Autowired
	public void setDao(QuestionFavoriteDao dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	public QuestionFavoritePage getPage(int pageNo, int pageSize) {
		QuestionFavoritePage result = null;
		Pagination<QuestionFavorite> page = dao.getPage(pageNo, pageSize);
		result = new QuestionFavoritePage(page);
		return result;
	}

	@Transactional(readOnly = true)
	@Override
	public QuestionFavorite findByUser(Long uid, Long questionid) {
		QuestionFavorite vote = new QuestionFavorite();
		vote.setId(-1l);
		Finder finder = Finder.create();
		finder.append("from QuestionFavorite q where q.user.id = :uid ");
		finder.setParam("uid",uid);
		finder.append(" and q.question.id = :questionid");
		finder.setParam("questionid", questionid);
		List<QuestionFavorite> vs = dao.find(finder);
		if (vs != null && vs.size() > 0) {
			vote = vs.get(0);
		} 
		return vote;
	}

	@Transactional(readOnly = true)
	@Override
	public QuestionFavoritePage pageByUser(Long uid, int pageNo, int pageSize) {
		QuestionFavoritePage result = null;
		Finder finder=Finder.create();
		finder.append("from QuestionFavorite q where q.user.id=:uid ");
		finder.setParam("uid", uid);
		finder.append(" order by q.id desc ");
		Pagination<QuestionFavorite> page = dao.find(finder,pageNo, pageSize);
		result = new QuestionFavoritePage(page);
		return result;
	}

	@Transactional(readOnly = true)
	@Override
	public QuestionFavoritePage pageByQuestion(Long qid, int pageNo,
			int pageSize) {
		QuestionFavoritePage result = null;
		Finder finder=Finder.create();
		finder.append("from QuestionFavorite q where q.question.id=:qid ");
		finder.setParam("qid", qid);
		finder.append(" order by q.id desc ");
		Pagination<QuestionFavorite> page = dao.find(finder,pageNo, pageSize);
		result = new QuestionFavoritePage(page);
		return result;
	}
}