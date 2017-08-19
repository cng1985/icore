package com.ada.question.rest.api;

import com.ada.question.rest.page.AnswerPageVo;

/**
 * 问答api
 * 
 * @author 年高
 *
 */
public interface AnswerApi {

	/**
	 * 
	 * 
	 * @param questionid 问题id
	 * @param curPage 当前多少页
	 * @param pageSize 分页大小
	 * @return 回答分页集合
	 */
	AnswerPageVo pageByQuestion(Long questionid, Integer curPage, Integer pageSize);
}
