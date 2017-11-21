package com.ada.user.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.BaseDaoImpl;
import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.ada.user.dao.UserFriendDao;
import com.ada.user.entity.UserFriend;

@Repository
public class UserFriendDaoImpl extends BaseDaoImpl<UserFriend, Long> implements UserFriendDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public UserFriend findById(Long id) {
		UserFriend entity = get(id);
		return entity;
	}

	public UserFriend save(UserFriend bean) {
		if( bean.getUser()!=null&& bean.getFriend()!=null){
			bean.setAddDate(new Date());
			bean.setLastDate(new Date());
			Finder finder = Finder.create();
			finder.append("from UserFriend u where u.user.id=:uid");
			finder.setParam("uid", bean.getUser().getId());
			finder.append(" and u.friend.id =:fid");
			finder.setParam("fid", bean.getFriend().getId());
			List<UserFriend> rs = find(finder);
			if (rs != null && rs.size() > 0) {
				bean = rs.get(0);
				bean.setLastDate(new Date());
			} else {
				getSession().save(bean);
			}
		}
		return bean;
	}

	public UserFriend deleteById(Long id) {
		UserFriend entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserFriend> getEntityClass() {
		return UserFriend.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}