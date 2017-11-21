package com.ada.question.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.question.entity.Question;
public class QuestionPage extends PageRpc<Question> {

	public QuestionPage(Pagination<Question> page) {
		super(page);
	}

}
