package com.ada.article.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.article.entity.ArticleTag;
public class ArticleTagPage extends PageRpc<ArticleTag> {

	public ArticleTagPage(Pagination<ArticleTag> page) {
		super(page);
	}

}
