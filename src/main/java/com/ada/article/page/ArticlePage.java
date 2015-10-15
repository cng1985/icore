package com.ada.article.page;

import com.ada.article.entity.Article;
import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;

public class ArticlePage extends PageRpc<Article> {

	public ArticlePage(Pagination page) {
		super(page);
	}

}
