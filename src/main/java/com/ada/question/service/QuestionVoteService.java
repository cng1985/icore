package com.ada.question.service;

import com.ada.question.entity.QuestionVote;
import com.ada.question.page.QuestionVotePage;

public interface QuestionVoteService {
	QuestionVotePage getPage(int pageNo, int pageSize);

	QuestionVote findById(Long id);

	QuestionVote save(QuestionVote bean);
	
	QuestionVote vote(QuestionVote bean);

	QuestionVote update(QuestionVote bean);

	QuestionVote deleteById(Long id);
	
	QuestionVote[] deleteByIds(Long[] ids);
}