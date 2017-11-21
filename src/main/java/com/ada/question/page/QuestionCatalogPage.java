package com.ada.question.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.question.entity.QuestionCatalog;
public class QuestionCatalogPage extends PageRpc<QuestionCatalog> {

	public QuestionCatalogPage(Pagination<QuestionCatalog> page) {
		super(page);
	}

}
