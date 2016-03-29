package com.ada.article.rest.api;

import com.ada.article.rest.page.ArticleCommentPageVo;

/**
 * 文章评论接口
 * 
 * @author 年高
 *
 */
public interface ArticleCommentApi {

	public ArticleCommentPageVo page(Long articleid, Integer pageNo, Integer pageSize);
}
