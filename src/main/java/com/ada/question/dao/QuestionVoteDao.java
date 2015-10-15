package com.ada.question.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.question.entity.QuestionVote;

public interface QuestionVoteDao extends BaseDao<QuestionVote, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public QuestionVote findById(Long id);

	public QuestionVote save(QuestionVote bean);

	public QuestionVote updateByUpdater(Updater<QuestionVote> updater);

	public QuestionVote deleteById(Long id);
}