package com.ada.article.rest.vo;

import java.io.Serializable;
import java.util.Date;

import com.ada.user.rest.vo.UserVo;

/**
 * 文章评论
 * 
 * @author 年高
 *
 */
public class ArticleCommentVo implements Serializable {
	/**
	 * 
	 * 文章id
	 */
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 
	 * 评论内容
	 */
	private String contents;

	/**
	 * 
	 * 评论时间
	 */
	private Date addDate;

	/**
	 * 用户
	 */
	private UserVo user;

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public UserVo getUser() {
		return user;
	}

	public void setUser(UserVo user) {
		this.user = user;
	}

}
