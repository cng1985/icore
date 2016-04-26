package com.ada.user.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ada.data.entity.AbstractEntity;


@Entity
@Table(name = "user_github")
public class UserGitHub extends AbstractEntity {
	
	@ManyToOne
	@JoinColumn(name="userid")
	private UserInfo user;
	
	
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
	private String login;
	
	private String avatar_url;

	private String gravatar_id;

	private String url;
	private String html_url;
	private String followers_url;
	private String following_url;
	private String gists_url;
	private String starred_url;
	private String subscriptions_url;
	private String organizations_url;
	private String repos_url;
	private String events_url;
	private String received_events_url;
	private String type;
	private String site_admin;
	private String name;
	private String company;
	private String blog;
	private String location;
	private String email;
	private Integer public_repos;
	private Integer public_gists;
	private Integer followers;
	private Integer following;
	private Integer private_gists;
	private Integer total_private_repos;
	private Integer owned_private_repos;
	private Integer disk_usage;
	private Integer collaborators;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getAvatar_url() {
		return avatar_url;
	}
	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}
	public String getGravatar_id() {
		return gravatar_id;
	}
	public void setGravatar_id(String gravatar_id) {
		this.gravatar_id = gravatar_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getHtml_url() {
		return html_url;
	}
	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}
	public String getFollowers_url() {
		return followers_url;
	}
	public void setFollowers_url(String followers_url) {
		this.followers_url = followers_url;
	}
	public String getFollowing_url() {
		return following_url;
	}
	public void setFollowing_url(String following_url) {
		this.following_url = following_url;
	}
	public String getGists_url() {
		return gists_url;
	}
	public void setGists_url(String gists_url) {
		this.gists_url = gists_url;
	}
	public String getStarred_url() {
		return starred_url;
	}
	public void setStarred_url(String starred_url) {
		this.starred_url = starred_url;
	}
	public String getSubscriptions_url() {
		return subscriptions_url;
	}
	public void setSubscriptions_url(String subscriptions_url) {
		this.subscriptions_url = subscriptions_url;
	}
	public String getOrganizations_url() {
		return organizations_url;
	}
	public void setOrganizations_url(String organizations_url) {
		this.organizations_url = organizations_url;
	}
	public String getRepos_url() {
		return repos_url;
	}
	public void setRepos_url(String repos_url) {
		this.repos_url = repos_url;
	}
	public String getEvents_url() {
		return events_url;
	}
	public void setEvents_url(String events_url) {
		this.events_url = events_url;
	}
	public String getReceived_events_url() {
		return received_events_url;
	}
	public void setReceived_events_url(String received_events_url) {
		this.received_events_url = received_events_url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSite_admin() {
		return site_admin;
	}
	public void setSite_admin(String site_admin) {
		this.site_admin = site_admin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getBlog() {
		return blog;
	}
	public void setBlog(String blog) {
		this.blog = blog;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getPublic_repos() {
		return public_repos;
	}
	public void setPublic_repos(Integer public_repos) {
		this.public_repos = public_repos;
	}
	public Integer getPublic_gists() {
		return public_gists;
	}
	public void setPublic_gists(Integer public_gists) {
		this.public_gists = public_gists;
	}
	public Integer getFollowers() {
		return followers;
	}
	public void setFollowers(Integer followers) {
		this.followers = followers;
	}
	public Integer getFollowing() {
		return following;
	}
	public void setFollowing(Integer following) {
		this.following = following;
	}
	public Integer getPrivate_gists() {
		return private_gists;
	}
	public void setPrivate_gists(Integer private_gists) {
		this.private_gists = private_gists;
	}
	public Integer getTotal_private_repos() {
		return total_private_repos;
	}
	public void setTotal_private_repos(Integer total_private_repos) {
		this.total_private_repos = total_private_repos;
	}
	public Integer getOwned_private_repos() {
		return owned_private_repos;
	}
	public void setOwned_private_repos(Integer owned_private_repos) {
		this.owned_private_repos = owned_private_repos;
	}
	public Integer getDisk_usage() {
		return disk_usage;
	}
	public void setDisk_usage(Integer disk_usage) {
		this.disk_usage = disk_usage;
	}
	public Integer getCollaborators() {
		return collaborators;
	}
	public void setCollaborators(Integer collaborators) {
		this.collaborators = collaborators;
	}

}
