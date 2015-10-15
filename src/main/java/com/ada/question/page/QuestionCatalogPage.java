package com.ada.question.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.question.entity.QuestionCatalog;
public class QuestionCatalogPage extends PageRpc<QuestionCatalog> {

	public QuestionCatalogPage(Pagination<QuestionCatalog> page) {
		super(page);
	}

}
