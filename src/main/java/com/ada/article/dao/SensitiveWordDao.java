package com.ada.article.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.article.entity.SensitiveWord;

public interface SensitiveWordDao extends CriteriaDao<SensitiveWord,Long>{
	Pagination getPage(int pageNo, int pageSize);

	SensitiveWord findById(Long id);

	SensitiveWord save(SensitiveWord bean);

	SensitiveWord updateByUpdater(Updater<SensitiveWord> updater);

	SensitiveWord deleteById(Long id);
}