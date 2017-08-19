package com.ada.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.user.dao.UserFollowDao;
import com.ada.user.entity.UserFollow;
import com.ada.user.entity.UserInfo;
import com.ada.user.service.UserFollowService;

@Service
@Transactional
public class UserFollowServiceImpl implements UserFollowService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public UserFollow findById(Long id) {
		UserFollow entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public UserFollow save(UserFollow bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public UserFollow update(UserFollow bean) {
		Updater<UserFollow> updater = new Updater<UserFollow>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public UserFollow deleteById(Long id) {
		UserFollow bean = dao.deleteById(id);
		dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public UserFollow[] deleteByIds(Long[] ids) {
		UserFollow[] beans = new UserFollow[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserFollowDao dao;

	@Autowired
	public void setDao(UserFollowDao dao) {
		this.dao = dao;
	}
	
	
	@Transactional
	@Override
	public UserFollow follow(UserFollow bean) {
		UserFollow result=null;
		Finder finder = Finder.create();
		finder.append("from UserFollow u where u.userInfo.id=:userid");
		finder.setParam("userid", bean.getUser().getId());
		finder.append(" and u.follower.id=:followerid");
		finder.setParam("followerid", bean.getFollower().getId());
		List list=	dao.find(finder);
		if(list!=null&&list.size()>0){
			result=new UserFollow();
			result.setId(-1l);
		}else{
			result=dao.save(bean);
		}
		
		return result;
	}

	@Transactional
	@Override
	public UserFollow unFollow(UserFollow bean) {
		UserFollow result = new UserFollow();
		dao.deleteById(bean.getId());
		result.setId(-1l);
		return result;
	}
	@Transactional
	@Override
	public UserFollow follow(long userid, long followid) {
		if(userid==followid){
			UserFollow f=new UserFollow();
			f.setId(-2l);
			return f;
		}
		UserFollow result=null;
		Finder finder = Finder.create();
		finder.append("from UserFollow u where u.userInfo.id=:userid");
		finder.setParam("userid", userid);
		finder.append(" and u.follower.id=:followerid");
		finder.setParam("followerid", followid);
		List list=	dao.find(finder);
		if(list!=null&&list.size()>0){
			result=new UserFollow();
			result.setId(-1l);
		}else{
			UserFollow bean=new UserFollow();
			bean.setUser(UserInfo.fromId(userid));
			bean.setFollower(UserInfo.fromId(followid));
			result=dao.save(bean);
		}
		
		return result;
	}
	@Transactional
	@Override
	public UserFollow unFollow(long userid, long followid) {
		Finder finder = Finder.create();
		finder.append("from UserFollow u where u.userInfo.id=:userid");
		finder.setParam("userid", userid);
		finder.append(" and u.follower.id=:followerid");
		finder.setParam("followerid", followid);
		List<UserFollow> list=	dao.find(finder);
		UserFollow result=new UserFollow();
		if(list!=null&&list.size()>0){
			dao.delete(list.get(0));
			result.setId(1l);
		}else{
			result.setId(-1l);

		}
		return result;
	}
	
	@Transactional(readOnly = true)
	@Override
	public Pagination pageByUser(long userid, int pageNo, int pageSize) {
		Finder finder = Finder.create();
		finder.append("from UserFollow f where f.user.id=:userid");
		finder.setParam("userid", userid);
		finder.append("  order by f.id desc");
		return dao.find(finder, pageNo, pageSize);
	}
	@Transactional
	@Override
	public UserFollow remove(UserFollow bean) {
		UserFollow result = new UserFollow();
		Finder finder = Finder.create();
		finder.append("from UserFollow f where f.user.id=:userid");
		finder.setParam("userid", bean.getUser().getId());
		finder.append(" and  f.friend.id=:friendid ");
		finder.setParam("friendid", bean.getFollower().getId());
		List<UserFollow> follows = dao.find(finder);
		if (follows != null && follows.size() > 0) {
			dao.delete(follows.get(0));
			result.setId(1l);
			return null;
		} else {
			result.setId(-1l);
		}
		return result;
	}

}