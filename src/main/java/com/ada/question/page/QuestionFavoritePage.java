package com.ada.question.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.question.entity.QuestionFavorite;
public class QuestionFavoritePage extends PageRpc<QuestionFavorite> {

	public QuestionFavoritePage(Pagination<QuestionFavorite> page) {
		super(page);
	}

}
