package com.ada.question.dao;


import  com.quhaodian.data.core.BaseDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import  com.ada.question.entity.QuestionTag;

public interface QuestionTagDao extends BaseDao<QuestionTag, Long>{
	Pagination getPage(int pageNo, int pageSize);

	QuestionTag findById(Long id);

	QuestionTag save(QuestionTag bean);

	QuestionTag updateByUpdater(Updater<QuestionTag> updater);

	QuestionTag deleteById(Long id);
}