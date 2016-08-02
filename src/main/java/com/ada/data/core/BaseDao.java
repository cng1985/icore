package com.ada.data.core;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;

public interface BaseDao<T, ID extends Serializable> {

	public abstract T add(T t);

	public abstract T delete(T t);

	public abstract T update(T t);

	public abstract T merge(T t);

	public T findOne(Finder finder);

	public Pagination<T> find(Finder finder, int pageNo, int pageSize);

	public <X> Pagination<X>  findSql(Finder finder, int pageNo, int pageSize, Class<X> otoclass);

	public List<T> find(Finder finder);

	public Pagination<T> findByCriteria(Criteria crit, int pageNo, int pageSize);

	public List<T> find(String hql, Object... values);

	public List<T> findByProperty(String property, Object value);

	public int countQueryResult(Finder finder);

	public Long countQuery(Finder finder);

	public int countQuerySqlResult(Finder finder);

	public <X> X hql(Finder finder);

	/**
	 * hibernate 转换成sql
	 * 
	 * @param hql
	 * @return
	 */
	public String transHqlToSql(String hql);

	/**
	 * 
	 * @param sql
	 *            sql语句
	 * @param otoclass
	 *            需要转化的对象
	 * @return
	 */
	public <X> List<X> listSQL(String sql, Class<X> otoclass);

	
	public  <X> List<X> listSQL(String sql,Integer stat,Integer max, Class<X> otoclass);

	
	/**
	 * 
	 * @param sql
	 *            sql语句
	 * @param otoclass
	 *            需要转化的对象
	 * @return
	 */
	public <X> X oneSQL(String sql, Class<X> otoclass);

}