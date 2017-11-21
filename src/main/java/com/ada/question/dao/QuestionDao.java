package com.ada.question.dao;


import  com.quhaodian.data.core.BaseDao;
import com.quhaodian.data.core.CriteriaDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import  com.ada.question.entity.Question;

public interface QuestionDao extends CriteriaDao<Question, Long>{
	Pagination getPage(int pageNo, int pageSize);

	Question findById(Long id);

	Question save(Question bean);

	Question updateByUpdater(Updater<Question> updater);

	Question deleteById(Long id);
}