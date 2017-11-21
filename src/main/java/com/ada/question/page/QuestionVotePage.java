package com.ada.question.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.question.entity.QuestionVote;
public class QuestionVotePage extends PageRpc<QuestionVote> {

	public QuestionVotePage(Pagination<QuestionVote> page) {
		super(page);
	}

}
