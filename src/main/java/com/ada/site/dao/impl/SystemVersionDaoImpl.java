package com.ada.site.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.CriteriaDaoImpl;
import com.quhaodian.data.core.Pagination;
import com.ada.site.dao.SystemVersionDao;
import com.ada.site.entity.SystemVersion;

@Repository
public class SystemVersionDaoImpl extends CriteriaDaoImpl<SystemVersion, Long> implements SystemVersionDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public SystemVersion findById(Long id) {
		if (id == null) {
			return null;
		}
		SystemVersion entity = get(id);
		return entity;
	}

	public SystemVersion save(SystemVersion bean) {
		getSession().save(bean);

		return bean;
	}

	public SystemVersion deleteById(Long id) {
		SystemVersion entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	protected Class<SystemVersion> getEntityClass() {
		return SystemVersion.class;
	}

	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public Long next(String sequence) {
		SystemVersion v = null;
		List<SystemVersion> versions = findByProperty("sequence", sequence);
		if (versions == null || versions.size() == 0) {
			v = new SystemVersion();
			v.setSequence(sequence);
			v.setAddDate(new Date());
			v.setLastDate(new Date());
			v.setStep(1);
			v.setVersionnum(0l);
			save(v);
		} else {
			v = versions.get(0);
		}

		Long dbnum = v.getVersionnum();
		if (dbnum == null) {
			dbnum = 1l;
			v.setVersionnum(dbnum);
		}
		Long result = v.getVersionnum() + v.getStep();
		v.setVersionnum(result);
		return result;
	}
}