package com.ada.article.service;

import com.ada.article.entity.ArticleCatalog;
import com.ada.data.core.Pagination;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

/**
* Created by imake on 2017年05月30日09:19:28.
*/
public interface ArticleCatalogService {

	public ArticleCatalog findById(Integer id);

	public ArticleCatalog save(ArticleCatalog bean);

	public ArticleCatalog update(ArticleCatalog bean);

	public ArticleCatalog deleteById(Integer id);
	
	public ArticleCatalog[] deleteByIds(Integer[] ids);
	
	public Page<ArticleCatalog> findPage(Pageable pageable);
	
	public Page<ArticleCatalog> page(Pageable pageable);
	
	public Page<ArticleCatalog> page(Pageable pageable, Object search);

	public long count(Filter... filters);

	public	List<ArticleCatalog> findByTops(Integer pid);

	public List<ArticleCatalog> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);

	List<ArticleCatalog> findChild(int id);

	/**
	 * 查询当前节点下的所有节点
	 * @param id 节点id
	 * @return
	 */
	List<ArticleCatalog> findChilds(int id);


	List<ArticleCatalog> all();



	Pagination pageByPid(int pid, int pageNo, int pageSize);

}