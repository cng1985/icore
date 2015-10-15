package com.ada.article.page;

import com.ada.article.entity.ArticleComment;
import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;

public class ArticleCommentPage extends PageRpc<ArticleComment>{

	public ArticleCommentPage(Pagination page) {
		super(page);
	}

}
