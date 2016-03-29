package com.ada.article.rest.page;

import java.util.List;

import com.ada.article.rest.vo.ArticleCommentVo;
import com.ada.data.dto.PageRpc;

public class ArticleCommentPageVo {
	private List<ArticleCommentVo> list;

	public List<ArticleCommentVo> getList() {
		return list;
	}

	public void setList(List<ArticleCommentVo> list) {
		this.list = list;
	}

}
