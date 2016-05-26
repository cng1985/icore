package com.ada.area.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.area.dao.AreaDao;
import com.ada.area.entity.Area;
import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;

@Repository
public class AreaDaoImpl extends CriteriaDaoImpl<Area, Integer> implements AreaDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public Area findById(Integer id) {
		Area entity = get(id);
		return entity;
	}

	public Area save(Area bean) {
		getSession().save(bean);
		if (bean.getParentId() != null) {
			Area parent =findById(bean.getParentId());
			if (parent != null) {
				if (parent.getLevelinfo() != null) {
					bean.setLevelinfo(parent.getLevelinfo() + 1);
				} else {
					bean.setLevelinfo(2);
				}
				if (parent.getIds() != null) {
					bean.setIds(parent.getIds() + "," + bean.getId());

				} else {
					bean.setIds(parent.getId() + "," + bean.getId());
				}

			} else {
				bean.setLevelinfo(1);
				bean.setIds("" + bean.getId());
			}
		} else {
			bean.setLevelinfo(1);
			bean.setIds("" + bean.getId());
		}		
		return bean;
	}

	public Area deleteById(Integer id) {
		Area entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	protected Class<Area> getEntityClass() {
		return Area.class;
	}

	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	@Override
	public Area findByName(String name) {
		Area  resultone=null;

		List<Area>  result=null;
		Finder finder=Finder.create();
		finder.append(" from Area a  where a.name=:name");
		finder.setParam("name", name);
		result=find(finder);
		if(result!=null&&result.size()>0){
			resultone=result.get(0);
		}	
		return resultone;
	}

}