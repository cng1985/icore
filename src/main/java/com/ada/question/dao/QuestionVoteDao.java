package com.ada.question.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.question.entity.QuestionVote;

public interface QuestionVoteDao extends BaseDao<QuestionVote, Long>{
	Pagination getPage(int pageNo, int pageSize);

	QuestionVote findById(Long id);

	QuestionVote save(QuestionVote bean);

	QuestionVote updateByUpdater(Updater<QuestionVote> updater);

	QuestionVote deleteById(Long id);
}