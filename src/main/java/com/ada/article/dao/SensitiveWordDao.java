package com.ada.article.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.article.entity.SensitiveWord;

public interface SensitiveWordDao extends CriteriaDao<SensitiveWord,Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public SensitiveWord findById(Long id);

	public SensitiveWord save(SensitiveWord bean);

	public SensitiveWord updateByUpdater(Updater<SensitiveWord> updater);

	public SensitiveWord deleteById(Long id);
}