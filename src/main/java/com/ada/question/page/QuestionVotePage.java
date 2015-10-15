package com.ada.question.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.question.entity.QuestionVote;
public class QuestionVotePage extends PageRpc<QuestionVote> {

	public QuestionVotePage(Pagination<QuestionVote> page) {
		super(page);
	}

}
