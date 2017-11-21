package com.ada.question.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.question.entity.QuestionTag;
public class QuestionTagPage extends PageRpc<QuestionTag> {

	public QuestionTagPage(Pagination<QuestionTag> page) {
		super(page);
	}

}
