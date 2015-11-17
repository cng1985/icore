package com.ada.album.entity;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity {

	/**
	 *  数据库主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * 添加时间
	 */
	private Date addDate;

	/**
	 * 最新修改时间
	 */
	private Date lastDate;
	
	public AbstractEntity(){
		addDate=new Date();
		lastDate=new Date();
	}
}
