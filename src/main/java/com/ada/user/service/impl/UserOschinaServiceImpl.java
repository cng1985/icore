package com.ada.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.user.dao.UserOschinaDao;
import com.ada.user.entity.UserOschina;
import com.ada.user.service.UserOschinaService;
import com.young.http.Connection;
import com.young.http.HttpConnection;
import com.ada.user.page.UserOschinaPage;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class UserOschinaServiceImpl implements UserOschinaService {

	@Transactional(readOnly = true)
	public UserOschina findById(Long id) {
		UserOschina entity = dao.findById(id);
		return entity;
	}

	@Transactional
	public UserOschina save(UserOschina bean) {
		dao.save(bean);
		return bean;
	}

	@Transactional
	public UserOschina update(UserOschina bean) {
		Updater<UserOschina> updater = new Updater<UserOschina>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public UserOschina deleteById(Long id) {
		UserOschina bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public UserOschina[] deleteByIds(Long[] ids) {
		UserOschina[] beans = new UserOschina[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserOschinaDao dao;

	@Autowired
	public void setDao(UserOschinaDao dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	public UserOschinaPage getPage(int pageNo, int pageSize) {
		UserOschinaPage result = null;
		Finder finder = Finder.create();
		finder.append("from UserOschina f ");
		finder.append(" order by f.id desc  ");
		Pagination<UserOschina> page = dao.find(finder, pageNo, pageSize);
		result = new UserOschinaPage(page);
		return result;
	}

	@Transactional(readOnly = true)
	public Page<UserOschina> findPage(Pageable pageable) {
		return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters) {

		return dao.count(filters);

	}

	@Transactional(readOnly = true)
	public List<UserOschina> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders) {

		return dao.findList(first, count, filters, orders);

	}

	@Override
	public UserOschina login(String client_id, String client_secret, String grant_type, String redirect_uri,
			String code) {
		UserOschina result = new UserOschina();

		try {
			Connection con = HttpConnection.connect("http://www.oschina.net/action/openapi/token");
			con.data("client_id", client_id);
			con.data("client_secret", client_secret);
			con.data("grant_type", grant_type);
			con.data("redirect_uri", redirect_uri);
			con.data("code", code);
			con.data("dataType", "json");
			String body = con.execute().body();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
}