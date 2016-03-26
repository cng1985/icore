package com.ada.user.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.user.dao.UserFriendRequestDao;
import com.ada.user.entity.UserFriendRequest;
import com.ada.user.service.UserFriendRequestService;

@Service
@Transactional
public class UserFriendRequestServiceImpl implements UserFriendRequestService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public UserFriendRequest findById(Long id) {
		UserFriendRequest entity = dao.findById(id);
		return entity;
	}

	@Transactional
	public UserFriendRequest save(UserFriendRequest bean) {
		bean.setAddDate(new Date());
    	bean.setLastDate(new Date());
		Finder finder = Finder.create();
		finder.append("from UserFriendRequest u where u.user.id=:uid");
		finder.setParam("uid", bean.getUser().getId());
		finder.append(" and u.friend.id =:fid");
		finder.setParam("fid", bean.getFriend().getId());
		List<UserFriendRequest> rs = dao.find(finder);
		if(rs!=null&&rs.size()>0){
			bean=rs.get(0);
			bean.setLastDate(new Date());
		}else{
			dao.save(bean);
		}
		return bean;
	}

	@Transactional
	public UserFriendRequest update(UserFriendRequest bean) {
		Updater<UserFriendRequest> updater = new Updater<UserFriendRequest>(
				bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public UserFriendRequest deleteById(Long id) {
		UserFriendRequest bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public UserFriendRequest[] deleteByIds(Long[] ids) {
		UserFriendRequest[] beans = new UserFriendRequest[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserFriendRequestDao dao;

	@Autowired
	public void setDao(UserFriendRequestDao dao) {
		this.dao = dao;
	}
	

	@Transactional(readOnly = true)
	@Override
	public Pagination pageByUser(Long userid, String key, int pageNo,
			int pageSize) {
		Finder finder=Finder.create();
		finder.append("from  UserFriendRequest u where u.userInfo.id =:userid");
		finder.setParam("userid", userid);
		finder.append(" and u.userInfo.name like :key ");
		finder.setParam("key","%"+key+"%");
		finder.append(" order by u.id desc ");
		return dao.find(finder, pageNo, pageSize);
	}
	
	@Transactional(readOnly = true)
	@Override
	public Pagination pageByUser(Long userid, int pageNo, int pageSize) {
		Finder finder=Finder.create();
		finder.append("from  UserFriendRequest u where u.userInfo.id =:userid");
		finder.setParam("userid", userid);
		finder.append(" order by u.id desc ");
		return dao.find(finder, pageNo, pageSize);
	}
}