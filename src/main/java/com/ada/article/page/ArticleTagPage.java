package com.ada.article.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.article.entity.ArticleTag;
public class ArticleTagPage extends PageRpc<ArticleTag> {

	public ArticleTagPage(Pagination<ArticleTag> page) {
		super(page);
	}

}
