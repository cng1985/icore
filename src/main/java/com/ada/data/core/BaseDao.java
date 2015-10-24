package com.ada.data.core;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;

public interface BaseDao<T , ID extends Serializable> {

	public abstract T add(T t);

	public abstract T delete(T t);

	public abstract T update(T t);
	
	public abstract T merge(T t);

	public T findOne(Finder finder);

	public Pagination<T> find(Finder finder, int pageNo, int pageSize);
	public Pagination<T> findnsql(Finder finder, int pageNo, int pageSize,Class<?> otoclass);

	public List<T> find(Finder finder);
	public Pagination<T> findByCriteria(Criteria crit, int pageNo, int pageSize);
	public List<T> find(String hql, Object... values) ;
	public List<T> findByProperty(String property, Object value) ;
	
	public int countQueryResult(Finder finder);
	public int countQuerySqlResult(Finder finder);
}