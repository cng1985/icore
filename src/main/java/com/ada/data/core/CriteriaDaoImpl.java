package com.ada.data.core;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.ada.data.page.Filter;
import com.ada.data.page.Filter.Operator;
import com.ada.data.page.Order;
import com.ada.data.page.Order.Direction;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;

@SuppressWarnings("rawtypes")
public abstract class CriteriaDaoImpl<T, ID extends Serializable> extends BaseDaoImpl<T, ID>
		implements CriteriaDao<T, ID> {

	public Page<T> findPage(Pageable pageable) {
		
		Criteria criteriaBuilder = createCriteria();
		return findPage(criteriaBuilder, pageable);
	}

	public List<T> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders) {
		Criteria criteriaBuilder = createCriteria();
		addRestrictions(criteriaBuilder, filters);
		addOrders(criteriaBuilder, orders);
		if (first != null) {
			criteriaBuilder.setFirstResult(first);
		}
		if (count != null) {
			criteriaBuilder.setMaxResults(count);
		}
		return criteriaBuilder.list();
	}

	private void addOrders(Criteria criteriaQuery, List<Order> orders) {
		if (criteriaQuery == null || orders == null || orders.isEmpty()) {
			return;
		}
		for (Order order : orders) {
			if (order.getDirection() == Direction.asc) {
				criteriaQuery.addOrder(org.hibernate.criterion.Order.asc(order.getProperty()));
			} else if (order.getDirection() == Direction.desc) {
				criteriaQuery.addOrder(org.hibernate.criterion.Order.desc(order.getProperty()));
			}
		}
	}

	protected Page<T> findPage(Criteria criteriaQuery, Pageable pageable) {

		if (pageable == null) {
			pageable = new Pageable();
		}
		long total = count(createCriteria(), pageable.getFilters());
		int totalPages = (int) Math.ceil((double) total / (double) pageable.getPageSize());
		if (totalPages < pageable.getPageNumber()) {
			pageable.setPageNumber(totalPages);
		}
		addRestrictions(criteriaQuery, pageable.getFilters());
		addOrders(criteriaQuery, pageable);
		criteriaQuery.setFirstResult((pageable.getPageNumber() - 1) * pageable.getPageSize());
		criteriaQuery.setMaxResults(pageable.getPageSize());
		return new Page<T>(criteriaQuery.list(), total, pageable);
	}

	public long count(Filter... filters) {
		Criteria criteriaBuilder = createCriteria();
		return count(criteriaBuilder, filters != null ? Arrays.asList(filters) : null);
	}

	private void addOrders(Criteria criteriaQuery, Pageable pageable) {
		if (criteriaQuery == null || pageable == null) {
			return;
		}
		if (StringUtils.isNotEmpty(pageable.getOrderProperty()) && pageable.getOrderDirection() != null) {
			if (pageable.getOrderDirection() == Direction.asc) {
				criteriaQuery.addOrder(org.hibernate.criterion.Order.asc(pageable.getOrderProperty()));
			} else if (pageable.getOrderDirection() == Direction.desc) {
				criteriaQuery.addOrder(org.hibernate.criterion.Order.desc(pageable.getOrderProperty()));
			}
		}
		if (pageable.getOrders() != null) {
			for (Order order : pageable.getOrders()) {
				if (order.getDirection() == Direction.asc) {
					criteriaQuery.addOrder(org.hibernate.criterion.Order.asc(order.getProperty()));
				} else if (order.getDirection() == Direction.desc) {
					criteriaQuery.addOrder(org.hibernate.criterion.Order.desc(order.getProperty()));
				}
			}
		}
	}

	protected Long count(Criteria criteriaQuery, List<Filter> filters) {
		addRestrictions(criteriaQuery, filters);
		criteriaQuery.setProjection(Projections.rowCount());
		return (Long) criteriaQuery.uniqueResult();
	}

	private void addRestrictions(Criteria criteriaQuery, List<Filter> filters) {
		if (criteriaQuery == null || filters == null || filters.isEmpty()) {
			return;
		}
		for (Filter filter : filters) {
			if (filter == null || StringUtils.isEmpty(filter.getProperty())) {
				continue;
			}
			if (filter.getOperator() == Operator.eq && filter.getValue() != null) {
				criteriaQuery.add(Restrictions.eq(filter.getProperty(), filter.getValue()));

			} else if (filter.getOperator() == Operator.ne && filter.getValue() != null) {
				criteriaQuery.add(Restrictions.ne(filter.getProperty(), filter.getValue()));

			} else if (filter.getOperator() == Operator.gt && filter.getValue() != null) {
				criteriaQuery.add(Restrictions.gt(filter.getProperty(), filter.getValue()));

			} else if (filter.getOperator() == Operator.lt && filter.getValue() != null) {

				criteriaQuery.add(Restrictions.lt(filter.getProperty(), filter.getValue()));

			} else if (filter.getOperator() == Operator.ge && filter.getValue() != null) {
				criteriaQuery.add(Restrictions.ge(filter.getProperty(), filter.getValue()));

			} else if (filter.getOperator() == Operator.le && filter.getValue() != null) {
				criteriaQuery.add(Restrictions.le(filter.getProperty(), filter.getValue()));

			} else if (filter.getOperator() == Operator.like && filter.getValue() != null
					&& filter.getValue() instanceof String) {
				criteriaQuery.add(Restrictions.like(filter.getProperty(), filter.getValue()));

			} else if (filter.getOperator() == Operator.in && filter.getValue() != null) {
				if (filter.getValue() instanceof Collection) {
					criteriaQuery.add(Restrictions.in(filter.getProperty(), (Collection) filter.getValue()));
				}
			} else if (filter.getOperator() == Operator.isNull) {
				criteriaQuery.add(Restrictions.isNull(filter.getProperty()));

			} else if (filter.getOperator() == Operator.isNotNull) {
				criteriaQuery.add(Restrictions.isNotNull(filter.getProperty()));
			}
		}
		// criteriaQuery.where(restrictions);
	}

}