package com.ada.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.user.dao.UserNotificationDao;
import com.ada.user.entity.UserNotification;
import com.ada.user.page.UserNotificationPage;
import com.ada.user.service.UserNotificationService;

@Service
@Transactional
public class UserNotificationServiceImpl implements UserNotificationService {
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
}