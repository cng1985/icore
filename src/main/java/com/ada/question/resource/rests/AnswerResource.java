package com.ada.question.resource.rests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.question.dao.QuestionAnswerDao;
import com.ada.question.rest.api.AnswerApi;
import com.ada.question.rest.page.AnswerPageVo;

@Component
@Transactional
public class AnswerResource implements AnswerApi {

	
	@Autowired
	QuestionAnswerDao questionAnswerDao;
	
	@Override
	public AnswerPageVo pageByQuestion(Long questionid, Integer curPage, Integer pageSize) {
		AnswerPageVo result=new AnswerPageVo();
		
		Finder finder=Finder.create();
		finder.append("from QuestionAnswer q  where q.question.id =:qid");
		finder.setParam("qid", questionid);
		finder.append(" order by q.id desc ");
		questionAnswerDao.find(finder, curPage, pageSize);
		
		return result;
	}

}
