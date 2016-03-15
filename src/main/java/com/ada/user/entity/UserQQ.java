package com.ada.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ada.data.entity.AbstractEntity;

@Entity
@Table(name = "user_qq")
public class UserQQ extends AbstractEntity {

	@ManyToOne
	@JoinColumn(name="userid")
	private UserInfo user;
	
	
	/**
	 * 昵称
	 */
	@Column(name = "nickname")
	private String nickName;

	/**
	 * openid
	 */
	private String openid;

	/**
	 * accessToken
	 */
	@Column(name = "access_token")
	private String accessToken;

	/**
	 * 性别
	 */
	private String gender;
	
	/**
	 * 大小为30×30像素的QQ空间头像URL。
	 */
	@Column(name = "figureurl")
	private String figureUrl;

	/**
	 * 大小为50×50像素的QQ空间头像URL。
	 */
	@Column(name = "figureurl1")
	private String figureUrl1;

	/**
	 * 大小为100×100像素的QQ空间头像URL。
	 */
	@Column(name = "figureurl2")
	private String figureUrl2;

	/**
	 * 大小为40×40像素的QQ头像URL。
	 */
	@Column(name = "figureurl_qq_1")
	private String figureurlQq1;

	/**
	 * 大小为100×100像素的QQ头像URL。需要注意，不是所有的用户都拥有QQ的100x100的头像，但40x40像素则是一定会有。
	 */
	@Column(name = "figureurl_qq_2")
	private String figureurlQq2;

	/**
	 * 标识用户是否为黄钻用户（0：不是；1：是）。
	 */
	@Column(name = "yellow_vip")
	private Integer yellowVip;

	/**
	 * 标识用户是否为黄钻用户（0：不是；1：是）
	 */
	private Integer vip;
	/**
	 * 黄钻等级
	 */
	@Column(name = "yellow_level")
	private Integer yellowVipLevel;

	/**
	 * 黄钻等级
	 */
	@Column(name = "level_info")
	private Integer level;

	/**
	 * 标识是否为年费黄钻用户（0：不是； 1：是）
	 */
	@Column(name = "yellow_year_vip")
	private Integer yellowYearVip;

	/**
	 * 省份
	 */
	private String province;

	/**
	 * 城市
	 */
	private String city;

	/**
	 * 出生年
	 */
	private Integer year;

	public String getAccessToken() {
		return accessToken;
	}

	public String getCity() {
		return city;
	}

	public String getFigureUrl() {
		return figureUrl;
	}

	public String getFigureUrl1() {
		return figureUrl1;
	}

	public String getFigureUrl2() {
		return figureUrl2;
	}

	public String getFigureurlQq1() {
		return figureurlQq1;
	}

	public String getFigureurlQq2() {
		return figureurlQq2;
	}

	public String getGender() {
		return gender;
	}

	public Integer getLevel() {
		return level;
	}

	public String getNickName() {
		return nickName;
	}

	public String getOpenid() {
		return openid;
	}

	public String getProvince() {
		return province;
	}

	public UserInfo getUser() {
		return user;
	}

	public Integer getVip() {
		return vip;
	}

	public Integer getYear() {
		return year;
	}

	public Integer getYellowVip() {
		return yellowVip;
	}

	public Integer getYellowVipLevel() {
		return yellowVipLevel;
	}

	public Integer getYellowYearVip() {
		return yellowYearVip;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setFigureUrl(String figureUrl) {
		this.figureUrl = figureUrl;
	}

	public void setFigureUrl1(String figureUrl1) {
		this.figureUrl1 = figureUrl1;
	}

	public void setFigureUrl2(String figureUrl2) {
		this.figureUrl2 = figureUrl2;
	}

	public void setFigureurlQq1(String figureurlQq1) {
		this.figureurlQq1 = figureurlQq1;
	}

	public void setFigureurlQq2(String figureurlQq2) {
		this.figureurlQq2 = figureurlQq2;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public void setVip(Integer vip) {
		this.vip = vip;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public void setYellowVip(Integer yellowVip) {
		this.yellowVip = yellowVip;
	}

	public void setYellowVipLevel(Integer yellowVipLevel) {
		this.yellowVipLevel = yellowVipLevel;
	}

	public void setYellowYearVip(Integer yellowYearVip) {
		this.yellowYearVip = yellowYearVip;
	}

	@Override
	public String toString() {
		return "UserQQ [nickName=" + nickName + ", openid=" + openid + ", accessToken=" + accessToken + ", gender="
				+ gender + ", figureUrl=" + figureUrl + ", figureUrl1=" + figureUrl1 + ", figureUrl2=" + figureUrl2
				+ ", figureurlQq1=" + figureurlQq1 + ", figureurlQq2=" + figureurlQq2 + ", yellowVip=" + yellowVip
				+ ", vip=" + vip + ", yellowVipLevel=" + yellowVipLevel + ", level=" + level + ", yellowYearVip="
				+ yellowYearVip + ", province=" + province + ", city=" + city + ", year=" + year + "]";
	}

}
