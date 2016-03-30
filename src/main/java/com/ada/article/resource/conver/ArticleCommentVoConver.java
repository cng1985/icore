package com.ada.article.resource.conver;

import com.ada.article.entity.ArticleComment;
import com.ada.article.rest.vo.ArticleCommentVo;
import com.ada.data.rest.core.Conver;
import com.ada.user.resource.conver.UserVoConver;
import com.ada.user.rest.vo.UserVo;

public class ArticleCommentVoConver implements Conver<ArticleCommentVo, ArticleComment>{

	public ArticleCommentVo conver(ArticleComment source){
		ArticleCommentVo result=new ArticleCommentVo();
		result.setAddDate(source.getAddDate());
		result.setId(source.getId());
		result.setContents(source.getContents());
		UserVoConver conver=new UserVoConver();
		UserVo user=conver.conver(source.getUser());
		result.setUser(user);
		return result;
		
		
		
	}
}
