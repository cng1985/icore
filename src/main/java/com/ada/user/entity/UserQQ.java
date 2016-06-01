package com.ada.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ada.data.entity.AbstractEntity;

@Entity
@Table(name = "user_oauth_info_qq")
public class UserQQ extends AbstractEntity {
	
	/**
	 * accessToken
	 */
	@Column(name = "access_token")
	private String accessToken;
	private String appid;

	/**
	 * 城市
	 */
	private String city;

	/**
	 * 大小为30×30像素的QQ空间头像URL。
	 */
	@Column(name = "figureurl")
	private String figureurl;

	/**
	 * 大小为50×50像素的QQ空间头像URL。
	 */
	@Column(name = "figureurl1")
	private String figureurl_1;

	/**
	 * 大小为100×100像素的QQ空间头像URL。
	 */
	@Column(name = "figureurl2")
	private String figureurl_2;

	/**
	 * 大小为40×40像素的QQ头像URL。
	 */
	@Column(name = "figureurl_qq_1")
	private String figureurl_qq_1;
	
	
	/**
	 * 大小为100×100像素的QQ头像URL。需要注意，不是所有的用户都拥有QQ的100x100的头像，但40x40像素则是一定会有。
	 */
	@Column(name = "figureurl_qq_2")
	private String figureurl_qq_2;

	/**
	 * 性别
	 */
	private String gender;

	/**
	 * 标识用户是否为黄钻用户（0：不是；1：是）。
	 */
	@Column(name = "yellow_vip")
	private Integer is_yellow_vip;

	/**
	 * 标识是否为年费黄钻用户（0：不是； 1：是）
	 */
	@Column(name = "yellow_year_vip")
	private Integer is_yellow_year_vip;
	
	/**
	 * 黄钻等级
	 */
	@Column(name = "level_info")
	private Integer level;

	/**
	 * 昵称
	 */
	@Column(name = "nickname")
	private String nickname;

	/**
	 * openid
	 */
	private String openid;

	/**
	 * 省份
	 */
	private String province;

	private   Integer ret;


	/**
	 * 标识用户是否为黄钻用户（0：不是；1：是）
	 */
	private Integer vip;
	/**
	 * 出生年
	 */
	private Integer year;

	/**
	 * 黄钻等级
	 */
	@Column(name = "yellow_level")
	private Integer yellow_vip_level;

	public String getAccessToken() {
		return accessToken;
	}

	public String getAppid() {
		return appid;
	}

	public String getCity() {
		return city;
	}

	public String getFigureurl() {
		return figureurl;
	}

	public String getFigureurl_1() {
		return figureurl_1;
	}

	public String getFigureurl_2() {
		return figureurl_2;
	}

	public String getFigureurl_qq_1() {
		return figureurl_qq_1;
	}

	public String getFigureurl_qq_2() {
		return figureurl_qq_2;
	}

	public String getGender() {
		return gender;
	}

	public Integer getIs_yellow_vip() {
		return is_yellow_vip;
	}

	public Integer getIs_yellow_year_vip() {
		return is_yellow_year_vip;
	}

	public Integer getLevel() {
		return level;
	}

	public String getNickname() {
		return nickname;
	}

	public String getOpenid() {
		return openid;
	}

	public String getProvince() {
		return province;
	}

	public Integer getRet() {
		return ret;
	}

	public Integer getVip() {
		return vip;
	}

	public Integer getYear() {
		return year;
	}

	public Integer getYellow_vip_level() {
		return yellow_vip_level;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setFigureurl(String figureurl) {
		this.figureurl = figureurl;
	}

	public void setFigureurl_1(String figureurl_1) {
		this.figureurl_1 = figureurl_1;
	}

	public void setFigureurl_2(String figureurl_2) {
		this.figureurl_2 = figureurl_2;
	}

	public void setFigureurl_qq_1(String figureurl_qq_1) {
		this.figureurl_qq_1 = figureurl_qq_1;
	}

	public void setFigureurl_qq_2(String figureurl_qq_2) {
		this.figureurl_qq_2 = figureurl_qq_2;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setIs_yellow_vip(Integer is_yellow_vip) {
		this.is_yellow_vip = is_yellow_vip;
	}

	public void setIs_yellow_year_vip(Integer is_yellow_year_vip) {
		this.is_yellow_year_vip = is_yellow_year_vip;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setRet(Integer ret) {
		this.ret = ret;
	}

	public void setVip(Integer vip) {
		this.vip = vip;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public void setYellow_vip_level(Integer yellow_vip_level) {
		this.yellow_vip_level = yellow_vip_level;
	}



}
