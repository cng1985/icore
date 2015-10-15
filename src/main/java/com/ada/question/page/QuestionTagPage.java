package com.ada.question.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.question.entity.QuestionTag;
public class QuestionTagPage extends PageRpc<QuestionTag> {

	public QuestionTagPage(Pagination<QuestionTag> page) {
		super(page);
	}

}
