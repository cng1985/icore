package com.ada.approve.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.approve.dao.TaskDao;
import com.ada.approve.entity.Task;
import com.quhaodian.data.core.CriteriaDaoImpl;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.page.Filter;

@Repository
public class TaskDaoImpl extends CriteriaDaoImpl<Task, Long> implements TaskDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public Task findById(Long id) {
		Task entity = get(id);
		return entity;
	}

	public Task save(Task bean) {
		getSession().save(bean);
		return bean;
	}

	public Task deleteById(Long id) {
		Task entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	protected Class<Task> getEntityClass() {
		return Task.class;
	}

	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public List<Date> list(long uid, int year, int month) {
		List<Date> result = new ArrayList<Date>();
		SQLQuery query = getSession().createSQLQuery(
				"select * from approve_task where year(approve_task.addDate)=:cyear and month(approve_task.addDate)=:cmonth and approve_task.user_id =:uid group by date_format(approve_task.addDate,'%Y-%m-%d')");

		query.setParameter("cyear", year);
		query.setParameter("cmonth", month);
		query.setParameter("uid", uid);
		List<Task> tasks = query.addEntity(Task.class).list();
		if (tasks != null) {
			for (Task task : tasks) {
				result.add(task.getAddDate());
			}
		}
		return result;

	}

	@Override
	public int deleteForCatalog(Long oid, Integer catalog) {
        int result=0;
		List<Filter> filters = new ArrayList<Filter>();
		filters.add(Filter.eq("oid", oid));
		filters.add(Filter.eq("catalog", catalog));
		List<Task> tasks = findList(0, 1000, filters, null);
		if (tasks!=null&&tasks.size()>0) {
			result=tasks.size();
			for (Task task : tasks) {
				delete(task);
			}
		}
		return result;
	}
}