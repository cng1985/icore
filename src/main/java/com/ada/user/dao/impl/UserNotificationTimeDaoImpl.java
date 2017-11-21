package com.ada.user.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.CriteriaDaoImpl;
import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.ada.user.dao.UserNotificationTimeDao;
import com.ada.user.entity.UserInfo;
import com.ada.user.entity.UserNotificationTime;

@Repository
public class UserNotificationTimeDaoImpl extends CriteriaDaoImpl<UserNotificationTime, Long> implements UserNotificationTimeDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public UserNotificationTime findById(Long id) {
		UserNotificationTime entity = get(id);
		return entity;
	}

	public UserNotificationTime save(UserNotificationTime bean) {
		getSession().save(bean);
		return bean;
	}

	public UserNotificationTime deleteById(Long id) {
		UserNotificationTime entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserNotificationTime> getEntityClass() {
		return UserNotificationTime.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}

	@Override
	public UserNotificationTime findByUser(Long id) {
		UserNotificationTime result=null;
		Finder finder=Finder.create();
		finder.append("from UserNotificationTime t where t.user.id =:uid");
		finder.setParam("uid", id);
		List<UserNotificationTime> times=	find(finder);
		if (times!=null&&times.size()>0) {
			result=times.get(0);
		}else{
			result=new UserNotificationTime();
			result.setUser(UserInfo.fromId(id));
			add(result);
		}
		return result;
	}

	@Override
	public UserNotificationTime findByUser(UserInfo user) {
		UserNotificationTime result=null;
		Finder finder=Finder.create();
		finder.append("from UserNotificationTime t where t.user.id =:uid");
		finder.setParam("uid", user.getId());
		List<UserNotificationTime> times=	find(finder);
		if (times!=null&&times.size()>0) {
			result=times.get(0);
			if (result.getLastDate()==null) {
				result.setLastDate(new Date());
			}
		}else{
			result=new UserNotificationTime();
			result.setUser(user);
			result.setLastDate(user.getAddDate());
			if (result.getLastDate()==null) {
				result.setLastDate(new Date());
			}
			add(result);
		}
		return result;
	}
}