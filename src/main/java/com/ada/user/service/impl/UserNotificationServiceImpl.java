package com.ada.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import com.ada.user.dao.UserInfoDao;
import com.ada.user.dao.UserNotificationDao;
import com.ada.user.dao.UserNotificationMemberDao;
import com.ada.user.entity.UserInfo;
import com.ada.user.entity.UserNotification;
import com.ada.user.entity.UserNotificationMember;
import com.ada.user.page.UserNotificationPage;
import com.ada.user.service.UserNotificationService;

@Service
@Transactional
public class UserNotificationServiceImpl implements UserNotificationService {
	
	
	@Autowired
	private UserNotificationMemberDao userNotificationMemberDao;
	
	@Autowired
	private UserInfoDao userInfoDao;
	
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public UserNotification findById(Long id) {
		UserNotification entity = dao.findById(id);
		return entity;
	}

	@Transactional
	public UserNotification save(UserNotification bean) {
		dao.save(bean);
		return bean;
	}

	@Transactional
	public UserNotification update(UserNotification bean) {
		Updater<UserNotification> updater = new Updater<UserNotification>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public UserNotification deleteById(Long id) {
		UserNotification bean = dao.deleteById(id);
		dao.deleteById(id);
		return bean;
	}

	@Transactional
	public UserNotification[] deleteByIds(Long[] ids) {
		UserNotification[] beans = new UserNotification[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserNotificationDao dao;

	@Autowired
	public void setDao(UserNotificationDao dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	@Override
	public UserNotificationPage pageByUser(Long userid, int pageNo, int pageSize) {
		UserNotificationPage result = null;

		Finder finder = Finder.create();
		finder.append("from UserNotification n where n.user.id=:userid");
		finder.setParam("userid", userid);
		finder.append(" and n.state =1  ");
		finder.append(" order by n.id desc ");
		
		Pagination<UserNotification> page = dao.find(finder, pageNo, pageSize);

		result = new UserNotificationPage(page);
		return result;
	}

	@Transactional(readOnly = true)
	@Override
	public UserNotificationPage pageByUserUnRead(Long userid, int pageNo,
			int pageSize) {
		UserNotificationPage result = null;

		Finder finder = Finder.create();
		finder.append("from UserNotification n where n.user.id=:userid");
		finder.setParam("userid", userid);
		finder.append(" order by n.id desc ");
		Pagination<UserNotification> page = dao.find(finder, pageNo, pageSize);

		result = new UserNotificationPage(page);
		return result;
	}
	@Transactional
	@Override
	public UserNotification send(UserNotification bean, List<UserInfo> users) {
		dao.save(bean);
		if (users!=null) {
			for (UserInfo userInfo : users) {
				UserNotificationMember nm = new UserNotificationMember();
				nm.setNotification(bean);
				nm.setUser(userInfo);
				nm.setState(0);
				userNotificationMemberDao.save(nm);
			}
			bean.setNums(users.size());
		}
		
		return bean;
	}

	@Transactional
	@Override
	public UserNotification send(Long nid, List<UserInfo> users) {
		UserNotification bean=dao.findById(nid);
		if (users!=null&&bean!=null) {
			for (UserInfo userInfo : users) {
				UserNotificationMember nm = new UserNotificationMember();
				nm.setNotification(bean);
				nm.setUser(userInfo);
				nm.setState(0);
				userNotificationMemberDao.save(nm);
			}
			bean.setNums(users.size());
		}
		return bean;
	}

	@Transactional(readOnly = true)
	@Override
	public Page<UserNotification> findPage(Pageable pageable) {
		 return dao.findPage(pageable);
	}

	@Override
	public UserNotification notice(UserNotification bean) {
		UserNotification result=	dao.save(bean);

		return result;
	}

	@Transactional
	@Override
	public UserNotification noticeAll(UserNotification bean) {
		
		
		
		UserNotification result=	dao.save(bean);
		Finder finder=Finder.create("from UserInfo u");
		List<UserInfo> us=	userInfoDao.find(finder);
		if (us!=null) {
			for (UserInfo userInfo : us) {
				UserNotificationMember nm = new UserNotificationMember();
				nm.setNotification(bean);
				nm.setUser(userInfo);
				nm.setState(0);
				userNotificationMemberDao.save(nm);
			}
		}
		
		return result;
	}
}