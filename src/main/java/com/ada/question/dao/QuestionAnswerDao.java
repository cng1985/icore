package com.ada.question.dao;


import  com.quhaodian.data.core.BaseDao;
import com.quhaodian.data.core.CriteriaDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import  com.ada.question.entity.QuestionAnswer;

public interface QuestionAnswerDao extends CriteriaDao<QuestionAnswer, Long>{
	Pagination getPage(int pageNo, int pageSize);

	QuestionAnswer findById(Long id);

	QuestionAnswer save(QuestionAnswer bean);

	QuestionAnswer updateByUpdater(Updater<QuestionAnswer> updater);

	QuestionAnswer deleteById(Long id);
}