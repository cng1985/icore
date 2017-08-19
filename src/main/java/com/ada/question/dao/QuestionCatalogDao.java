package com.ada.question.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import  com.ada.question.entity.QuestionCatalog;

/**
* Created by imake on 2017年05月30日09:15:17.
*/
public interface QuestionCatalogDao extends CriteriaDao<QuestionCatalog,Integer>{

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
	Integer updateNums(Integer id);

	/**
	 * 从子节点更新到根节点
	 *
	 * @param id
	 *            子节点id
	 * @return 更新节点层数
	 */
	Integer updateNumsAndTime(Integer id);
}