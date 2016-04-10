package com.ada.question.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.question.dao.QuestionAnswerDao;
import com.ada.question.dao.QuestionVoteDao;
import com.ada.question.entity.QuestionAnswer;
import com.ada.question.entity.QuestionVote;
import com.ada.question.page.QuestionVotePage;
import com.ada.question.service.QuestionVoteService;

@Service
@Transactional
public class QuestionVoteServiceImpl implements QuestionVoteService {
	@Transactional(readOnly = true)
	public QuestionVotePage getPage(int pageNo, int pageSize) {
	    QuestionVotePage result=null;
		Pagination<QuestionVote> page = dao.getPage(pageNo, pageSize);
		result=new QuestionVotePage(page);
		return result;
	}

	@Transactional(readOnly = true)
	public QuestionVote findById(Long id) {
		QuestionVote entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public QuestionVote save(QuestionVote bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public QuestionVote update(QuestionVote bean) {
		Updater<QuestionVote> updater = new Updater<QuestionVote>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public QuestionVote deleteById(Long id) {
		QuestionVote bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public QuestionVote[] deleteByIds(Long[] ids) {
		QuestionVote[] beans = new QuestionVote[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private QuestionVoteDao dao;

	@Autowired
	public void setDao(QuestionVoteDao dao) {
		this.dao = dao;
	}
	
	@Autowired
	QuestionAnswerDao answerDao;

	@Transactional
	@Override
	public QuestionVote vote(QuestionVote bean) {
		QuestionVote vote=new QuestionVote();
		vote.setId(-1l);
		if(bean.getQuestion()==null||bean.getUser()==null){
			return vote;
		}
		Finder finder=Finder.create();
		finder.append("from QuestionVote q where q.user.id = :uid ");
		finder.setParam("uid", bean.getUser().getId());
		finder.append(" and q.question.id = :aid");
		finder.setParam("aid", bean.getQuestion().getId());
		List<QuestionVote> vs=	dao.find(finder);
		if (vs!=null&&vs.size()>0) {
			
		}else{
			vote=dao.save(bean);
		}
		Finder coutfinder=Finder.create();
		coutfinder.append("from QuestionVote q where q.question.id=:aid");
		coutfinder.setParam("aid", bean.getQuestion().getId());
		int size=dao.countQueryResult(coutfinder);
		QuestionAnswer answer=	answerDao.findById(bean.getQuestion().getId());
		if(answer!=null){
			answer.setUps(size);
		}
		return vote;
	}
}