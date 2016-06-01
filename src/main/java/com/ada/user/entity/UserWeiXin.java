package com.ada.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ada.data.entity.AbstractEntity;

@Entity
@Table(name = "user_oauth_info_weixin")
public class UserWeiXin extends AbstractEntity {

	
	
	/**
	 * accessToken
	 */
	@Column(name = "access_token")
	private String accessToken;
	
	private String city;

	private String country;

	private String headimgurl;

	@Column(name = "nickname")
	private String nickName;

	private String openid;

	private String province;

	private String sex;

	/**
	 * 用户统一标识。针对一个微信开放平台帐号下的应用，同一用户的unionid是唯一的。
	 */
	private String unionid;

	public String getAccessToken() {
		return accessToken;
	}
	
	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getHeadimgurl() {
		return headimgurl;
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

	public String getSex() {
		return sex;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
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

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	
	

}
