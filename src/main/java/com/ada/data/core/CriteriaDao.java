package com.ada.data.core;

import java.io.Serializable;
import java.util.List;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;

public interface CriteriaDao<T, ID extends Serializable> extends BaseDao<T, ID> {
	public Page<T> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<T> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
}
