package com.ada.question.resource.conver;

import com.ada.data.rest.core.Conver;
import com.ada.data.rest.core.ConverCodeMake;
import com.ada.question.entity.QuestionAnswer;
import com.ada.question.rest.vo.AnswerVo;

public class AnswerVoConver implements Conver<AnswerVo, QuestionAnswer> {

	@Override
	public AnswerVo conver(QuestionAnswer source) {
		AnswerVo result=new AnswerVo();
		result.setAddDate(source.getAddDate());
		result.setContents(source.getContents());
		result.setId(source.getId());
		result.setImages(source.getImages());
		result.setLastDate(source.getLastDate());
		result.setState(source.getState());
		result.setTitle(source.getTitle());
		result.setUps(source.getUps());
		return result;
	}
	public static void main(String[] args) {
		ConverCodeMake make=new ConverCodeMake();
		make.make2(AnswerVo.class, QuestionAnswer.class);
	}

}
