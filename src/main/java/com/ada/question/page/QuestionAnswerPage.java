package com.ada.question.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.question.entity.QuestionAnswer;
public class QuestionAnswerPage extends PageRpc<QuestionAnswer> {

	public QuestionAnswerPage(Pagination<QuestionAnswer> page) {
		super(page);
	}

}
