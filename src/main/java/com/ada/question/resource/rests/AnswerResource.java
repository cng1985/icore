package com.ada.question.resource.rests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.rest.core.ConverUtils;
import com.ada.question.dao.QuestionAnswerDao;
import com.ada.question.entity.QuestionAnswer;
import com.ada.question.resource.conver.AnswerVoConver;
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
		Pagination<QuestionAnswer> pager=	questionAnswerDao.find(finder, curPage, pageSize);
		ConverUtils.coverpage(result, pager, new AnswerVoConver());
		return result;
	}

}
