package com.ada.article.dao;


import  com.quhaodian.data.core.CriteriaDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import  com.ada.article.entity.SensitiveWord;

public interface SensitiveWordDao extends CriteriaDao<SensitiveWord,Long>{
	Pagination getPage(int pageNo, int pageSize);

	SensitiveWord findById(Long id);

	SensitiveWord save(SensitiveWord bean);

	SensitiveWord updateByUpdater(Updater<SensitiveWord> updater);

	SensitiveWord deleteById(Long id);
}