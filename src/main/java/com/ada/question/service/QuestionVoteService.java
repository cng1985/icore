package com.ada.question.service;

import com.ada.question.entity.QuestionVote;
import com.ada.question.page.QuestionVotePage;

public interface QuestionVoteService {
	public QuestionVotePage getPage(int pageNo, int pageSize);

	public QuestionVote findById(Long id);

	public QuestionVote save(QuestionVote bean);
	
	public QuestionVote vote(QuestionVote bean);

	public QuestionVote update(QuestionVote bean);

	public QuestionVote deleteById(Long id);
	
	public QuestionVote[] deleteByIds(Long[] ids);
}