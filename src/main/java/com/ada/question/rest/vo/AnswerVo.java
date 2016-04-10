package com.ada.question.rest.vo;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 问题回答
 * 
 * @author 年高
 *
 */
public class AnswerVo implements Serializable{

	private Long id;

	
	/**
	 * 标题
	 */
	private String title;

	/**
	 * 回答内容
	 */
	private String contents;

	/**
	 * 图片集合
	 */
	private String images;

	/**
	 * 支持人数
	 */
	private Integer ups;
	
	/**
	 * 添加时间
	 */
	private Date addDate;

	/**
	 * 更新时间
	 */
	private Date lastDate;
	
	
	/**
	 * 回答是否被采纳
	 */
	private Integer state;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}


	public String getImages() {
		return images;
	}


	public void setImages(String images) {
		this.images = images;
	}


	public Integer getUps() {
		return ups;
	}


	public void setUps(Integer ups) {
		this.ups = ups;
	}


	public Date getAddDate() {
		return addDate;
	}


	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}


	public Date getLastDate() {
		return lastDate;
	}


	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}


	public Integer getState() {
		return state;
	}


	public void setState(Integer state) {
		this.state = state;
	}
	
	
}
