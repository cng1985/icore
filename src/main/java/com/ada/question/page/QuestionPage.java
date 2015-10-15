package com.ada.question.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.question.entity.Question;
public class QuestionPage extends PageRpc<Question> {

	public QuestionPage(Pagination<Question> page) {
		super(page);
	}

}
