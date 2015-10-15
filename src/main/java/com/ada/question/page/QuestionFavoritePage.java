package com.ada.question.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.question.entity.QuestionFavorite;
public class QuestionFavoritePage extends PageRpc<QuestionFavorite> {

	public QuestionFavoritePage(Pagination<QuestionFavorite> page) {
		super(page);
	}

}
