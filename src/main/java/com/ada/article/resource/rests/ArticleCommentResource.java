package com.ada.article.resource.rests;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ada.article.dao.ArticleCommentDao;
import com.ada.article.entity.ArticleComment;
import com.ada.article.resource.conver.ArticleCommentVoConver;
import com.ada.article.rest.api.ArticleCommentApi;
import com.ada.article.rest.page.ArticleCommentPageVo;
import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.rest.core.ConverUtils;

@Transactional
@Component
public class ArticleCommentResource implements ArticleCommentApi {

	@Autowired
	private ArticleCommentDao dao;

	public ArticleCommentPageVo page(Long articleid, Integer pageNo, Integer pageSize) {
		ArticleCommentPageVo result = new ArticleCommentPageVo();

		Finder finder = Finder.create();
		finder.append("from ArticleComment a where a.article.id=:articleid");
		finder.setParam("articleid", articleid);
		finder.append("  order by a.id desc ");
		Pagination<ArticleComment> cs = dao.find(finder, pageNo, pageSize);
		ConverUtils.coverpage(result, cs, new ArticleCommentVoConver());
		return result;

	}

}
