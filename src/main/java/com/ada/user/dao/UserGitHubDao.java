package com.ada.user.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.user.entity.UserGitHub;

public interface UserGitHubDao extends CriteriaDao<UserGitHub, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserGitHub findById(Long id);

	public UserGitHub save(UserGitHub bean);

	public UserGitHub updateByUpdater(Updater<UserGitHub> updater);

	public UserGitHub deleteById(Long id);
}