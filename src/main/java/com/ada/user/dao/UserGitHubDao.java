package com.ada.user.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.user.entity.UserGitHub;

public interface UserGitHubDao extends CriteriaDao<UserGitHub, Long>{
	Pagination getPage(int pageNo, int pageSize);

	UserGitHub findById(Long id);

	UserGitHub save(UserGitHub bean);

	UserGitHub updateByUpdater(Updater<UserGitHub> updater);

	UserGitHub deleteById(Long id);
}