package com.ada.question.dao;


import com.ada.data.core.CriteriaDao;
import com.ada.data.core.Pagination;
import  com.ada.data.core.Updater;
import  com.ada.question.entity.QuestionCatalog;

public interface QuestionCatalogDao extends CriteriaDao<QuestionCatalog, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public QuestionCatalog findById(Integer id);

	public QuestionCatalog save(QuestionCatalog bean);

	public QuestionCatalog updateByUpdater(Updater<QuestionCatalog> updater);

	public QuestionCatalog deleteById(Integer id);
	
	/**
	 * 从子节点更新到根节点
	 * 
	 * @param id
	 *            子节点id
	 * @return 更新节点层数
	 */
	public Integer updateNums(Integer id);
	
	/**
	 * 从子节点更新到根节点
	 * 
	 * @param id
	 *            子节点id
	 * @return 更新节点层数
	 */
	public Integer updateNumsAndTime(Integer id);
}