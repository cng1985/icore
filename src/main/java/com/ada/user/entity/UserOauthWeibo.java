package com.ada.user.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.quhaodian.data.entity.BaseEntity;

/**
 * 微博登陆后的信息
 * 
 * @author ada
 *
 */
@Entity
@Table(name = "user_oauth_info_weibo")
public class UserOauthWeibo extends BaseEntity {

	private String idstr;

	private String screen_name;

	private String name;

	private String province;

	private String city;

	private String location;
	private String description;
	private String url;
	private String profile_image_url;
	private String cover_image_phone;
	private String profile_url;
	private String domain;
	private String weihao;
	private String gender;
	private Integer followers_count;
	private Integer friends_count;
	private Integer pagefriends_count;
	private Integer statuses_count;
	private Integer favourites_count;

	private String avatar_large;

	private String avatar_hd;

	public String getIdstr() {
		return idstr;
	}

	public void setIdstr(String idstr) {
		this.idstr = idstr;
	}

	public String getScreen_name() {
		return screen_name;
	}

	public void setScreen_name(String screen_name) {
		this.screen_name = screen_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getProfile_image_url() {
		return profile_image_url;
	}

	public void setProfile_image_url(String profile_image_url) {
		this.profile_image_url = profile_image_url;
	}

	public String getCover_image_phone() {
		return cover_image_phone;
	}

	public void setCover_image_phone(String cover_image_phone) {
		this.cover_image_phone = cover_image_phone;
	}

	public String getProfile_url() {
		return profile_url;
	}

	public void setProfile_url(String profile_url) {
		this.profile_url = profile_url;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getWeihao() {
		return weihao;
	}

	public void setWeihao(String weihao) {
		this.weihao = weihao;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getFollowers_count() {
		return followers_count;
	}

	public void setFollowers_count(Integer followers_count) {
		this.followers_count = followers_count;
	}

	public Integer getFriends_count() {
		return friends_count;
	}

	public void setFriends_count(Integer friends_count) {
		this.friends_count = friends_count;
	}

	public Integer getPagefriends_count() {
		return pagefriends_count;
	}

	public void setPagefriends_count(Integer pagefriends_count) {
		this.pagefriends_count = pagefriends_count;
	}

	public Integer getStatuses_count() {
		return statuses_count;
	}

	public void setStatuses_count(Integer statuses_count) {
		this.statuses_count = statuses_count;
	}

	public Integer getFavourites_count() {
		return favourites_count;
	}

	public void setFavourites_count(Integer favourites_count) {
		this.favourites_count = favourites_count;
	}

	public String getAvatar_large() {
		return avatar_large;
	}

	public void setAvatar_large(String avatar_large) {
		this.avatar_large = avatar_large;
	}

	public String getAvatar_hd() {
		return avatar_hd;
	}

	public void setAvatar_hd(String avatar_hd) {
		this.avatar_hd = avatar_hd;
	}

}
