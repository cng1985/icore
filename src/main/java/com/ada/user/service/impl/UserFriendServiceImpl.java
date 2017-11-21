package com.ada.user.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.ada.user.dao.UserFriendDao;
import com.ada.user.entity.UserFriend;
import com.ada.user.entity.UserFriendRequest;
import com.ada.user.page.UserFriendPage;
import com.ada.user.service.UserFriendService;

@Service
@Transactional
public class UserFriendServiceImpl implements UserFriendService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public UserFriend findById(Long id) {
		UserFriend entity = dao.findById(id);
		return entity;
	}

	@Transactional
	public UserFriend save(UserFriend bean) {
		bean = dao.save(bean);
		if(bean.getUser()!=null&&bean.getFriend()!=null){
			UserFriend obean = new UserFriend();
			obean.setUser(bean.getFriend());
			obean.setFriend(bean.getUser());
			dao.save(obean);
		}
		return bean;
	}

	@Transactional
	public UserFriend update(UserFriend bean) {
		Updater<UserFriend> updater = new Updater<UserFriend>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public UserFriend deleteById(Long id) {

		UserFriend temp = dao.findById(id);
		if (temp != null) {
			Finder finder = Finder.create();
			finder.append("from UserFriend u where u.user.id=:uid");
			finder.setParam("uid", temp.getFriend().getId());
			finder.append(" and u.friend.id =:fid");
			finder.setParam("fid", temp.getUser().getId());
			UserFriend friend = dao.findOne(finder);
			if (friend != null) {
				dao.delete(friend);
			}
		}

		UserFriend bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public UserFriend[] deleteByIds(Long[] ids) {
		UserFriend[] beans = new UserFriend[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserFriendDao dao;

	@Autowired
	public void setDao(UserFriendDao dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	@Override
	public UserFriendPage pageByUser(long userid, int pageNo, int pageSize) {
		UserFriendPage result = null;

		Finder finder = Finder.create();
		finder.append("from UserFriend u where u.user.id =:uid");
		finder.setParam("uid", userid);
		finder.append("order by u.id desc");
		Pagination<UserFriend> p = dao.find(finder, pageNo, pageSize);
		result = new UserFriendPage(p);
		return result;
	}
	
	@Transactional(readOnly = true)
	@Override
	public Pagination pageByUser(Long id, String key, int pageNo, int pageSize) {
		Finder finder = Finder.create();
		finder.append("from UserFriend u where u.user.id=:uid");
		finder.setParam("uid", id);
		finder.append(" and u.user.name like :key ");
		finder.setParam("key","%"+ key+"%");
		finder.append("  order by u.id desc");
		Pagination page = dao.find(finder, pageNo, pageSize);
		return page;
	}
}