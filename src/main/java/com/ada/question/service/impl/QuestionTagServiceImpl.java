package com.ada.question.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.question.dao.QuestionTagDao;
import com.ada.question.entity.QuestionTag;
import com.ada.question.service.QuestionTagService;
import com.ada.question.page.QuestionTagPage;

@Service
@Transactional
public class QuestionTagServiceImpl implements QuestionTagService {
	

	@Transactional(readOnly = true)
	public QuestionTag findById(Long id) {
		QuestionTag entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public QuestionTag save(QuestionTag bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public QuestionTag update(QuestionTag bean) {
		Updater<QuestionTag> updater = new Updater<QuestionTag>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public QuestionTag deleteById(Long id) {
		QuestionTag bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public QuestionTag[] deleteByIds(Long[] ids) {
		QuestionTag[] beans = new QuestionTag[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private QuestionTagDao dao;

	@Autowired
	public void setDao(QuestionTagDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public QuestionTagPage getPage(int pageNo, int pageSize) {
	    QuestionTagPage result=null;
		Pagination<QuestionTag> page = dao.getPage(pageNo, pageSize);
		result=new QuestionTagPage(page);
		return result;
	}
}