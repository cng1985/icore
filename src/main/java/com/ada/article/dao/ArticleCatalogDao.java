package com.ada.article.dao;


import  com.quhaodian.data.core.CriteriaDao;
import  com.quhaodian.data.core.Updater;
import  com.ada.article.entity.ArticleCatalog;

/**
* Created by imake on 2017年05月30日09:19:28.
*/
public interface ArticleCatalogDao extends CriteriaDao<ArticleCatalog,Integer>{

	public ArticleCatalog findById(Integer id);

	public ArticleCatalog save(ArticleCatalog bean);

	public ArticleCatalog updateByUpdater(Updater<ArticleCatalog> updater);

	public ArticleCatalog deleteById(Integer id);


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