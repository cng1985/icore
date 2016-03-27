package com.ada.article.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ada.data.entity.AbstractEntity;
import com.ada.user.entity.UserInfo;
import com.openyelp.annotation.NoGson;

/**
 * 文章
 * 
 * @author 年高
 *
 */
@Entity
@Table(name = "article")
public class Article extends AbstractEntity {


	@NoGson
	@ManyToOne
	private ArticleCatalog catalog;

	
	@ManyToOne()
	private UserInfo user;
	
	
	private String contents;
	
	
	

	private String img;
	
	private String introduction;
	

	@NoGson
	@JoinTable(name = "article_link_tag")
	@ManyToMany
	private Set<ArticleTag> tags;

	private String title;

	private String exts;

	private String images;
	
	private Integer ups;

	/**
	 * 文章评论数量
	 */
	private Integer comments;
	
	/**
	 * 文章查看数量
	 */
	private Integer views;

	
	public ArticleCatalog getCatalog() {
		return catalog;
	}

	public Integer getComments() {
		if(comments==null){
			comments=0;
		}
		return comments;
	}

	public String getContents() {
		return contents;
	}

	public String getExts() {
		return exts;
	}
	public String getImages() {
		return images;
	}
	public String getImg() {
		return img;
	}
	public String getIntroduction() {
		return introduction;
	}
	public Set<ArticleTag> getTags() {
		if(tags==null){
			tags=new HashSet<ArticleTag>();
		}
		return tags;
	}
	public String getTitle() {
		return title;
	}
	public Integer getUps() {
		if(ups==null){
			ups=0;
		}
		return ups;
	}
	public UserInfo getUser() {
		return user;
	}

	public Integer getViews() {
		return views;
	}

	public void setCatalog(ArticleCatalog catalog) {
		this.catalog = catalog;
	}


	public void setComments(Integer comments) {
		this.comments = comments;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public void setExts(String exts) {
		this.exts = exts;
	}

	public void setImages(String images) {
		this.images = images;
	}


	public void setImg(String img) {
		this.img = img;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public void setTags(Set<ArticleTag> tags) {
		this.tags = tags;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	public void setUps(Integer ups) {
		this.ups = ups;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

}
