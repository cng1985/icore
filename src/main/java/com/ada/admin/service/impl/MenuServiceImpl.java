package com.ada.admin.service.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.admin.dao.MenuDao;
import com.ada.admin.entity.Menu;
import com.ada.admin.service.MenuService;
import com.ada.article.entity.ArticleCatalog;
import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public Menu findById(Integer id) {
		Menu entity = dao.findById(id);
		return entity;
	}

	@CacheEvict(allEntries = true, value = "menucache")
	@Transactional
	public Menu save(Menu bean) {
		bean.setNums(0l);
		dao.save(bean);
		if (bean.getParentId() != null) {
			Menu parent = dao.findById(bean.getParentId());
			if (parent != null) {
				if (parent.getLevelInfo() != null) {
					bean.setLevelInfo(parent.getLevelInfo() + 1);
				} else {
					bean.setLevelInfo(2);
				}
				if (parent.getIds() != null) {
					bean.setIds(parent.getIds() + "," + bean.getId());

				} else {
					bean.setIds(parent.getId() + "," + bean.getId());
				}

			} else {
				bean.setLevelInfo(1);
				bean.setIds("" + bean.getId());
			}
		} else {
			bean.setLevelInfo(1);
			bean.setIds("" + bean.getId());
		}
		updateNumsAndTime(bean.getParentId());
		return bean;
	}

	@CacheEvict(allEntries = true, value = "menucache")
	@Transactional
	public Menu update(Menu bean) {
		Updater<Menu> updater = new Updater<Menu>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@CacheEvict(allEntries = true, value = "menucache")
	@Transactional
	public Menu deleteById(Integer id) {

		Menu bean = dao.findById(id);
		dao.deleteById(id);
		updateNumsAndTime(bean.getParentId());
		return bean;
	}

	@Transactional
	public Menu[] deleteByIds(Integer[] ids) {
		Menu[] beans = new Menu[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private MenuDao dao;

	@Autowired
	public void setDao(MenuDao dao) {
		this.dao = dao;
	}

	@Cacheable(value = "menucache") // 缓存名叫 accountCache
	@Transactional(readOnly = true)
	@Override
	public List<Menu> findChild(int id) {
		Finder finder = Finder.create("from Menu t where t.parent.id=" + id);
		finder.append(" order by t.sortNum asc");
		finder.setCacheable(true);
		List ms = dao.find(finder);
		return ms;
	}

	@Override
	public List<Menu> findChildMenu(int id) {
		Finder finder = Finder.create("from Menu t where t.parent.id=" + id);
		finder.append(" and t.catalog =0 ");
		finder.append(" order by t.sortNum asc");
		finder.setCacheable(true);
		List ms = dao.find(finder);
		return ms;
	}

	@Transactional
	@Override
	public List<Menu> findTop(Integer id) {
		LinkedList<Menu> menus = new LinkedList<Menu>();
		Menu menu = dao.findById(id);
		while (menu.getParent() != null && menu.getId() > 0) {
			menus.addFirst(menu);
			menu = dao.findById(menu.getParentId());
		}

		if (menu != null && menu.getId() != null) {
			menus.addFirst(menu);
		}
		return menus;
	}

	@Override
	public Page<Menu> findPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return dao.findPage(pageable);
	}

	@Override
	public long count(Filter... filters) {
		// TODO Auto-generated method stub
		return dao.count(filters);
	}

	@Override
	public List<Menu> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders) {
		// TODO Auto-generated method stub
		return dao.findList(first, count, filters, orders);
	}

	@Override
	public List<Menu> childMenus(int id) {
		List<Menu> ms = null;
		Menu menu = dao.findById(id);
		if (menu != null) {
			Finder finder = Finder.create("from Menu t where t.lft >=:lft and t.rgt<=:rgt ");
			finder.append(" and t.catalog =0 ");
			finder.append(" order by t.lft asc");
			finder.setParam("lft", menu.getLft());
			finder.setParam("rgt", menu.getRgt());
			finder.setCacheable(false);
			ms = dao.find(finder);
		}

		return ms;
	}

	@Override
	public List<Menu> childs(int id) {
		List<Menu> ms = null;
		Menu menu = dao.findById(id);
		if (menu != null) {
			Finder finder = Finder.create("from Menu t where t.lft >=:lft and t.rgt<=:rgt ");
			finder.append(" order by t.lft asc");
			finder.setParam("lft", menu.getLft());
			finder.setParam("rgt", menu.getRgt());
			finder.setCacheable(false);
			ms = dao.find(finder);
		}

		return ms;
	}

	private void counts(Menu cur) {
		Finder finder = Finder.create();
		finder.append("from Menu a where a.parent.lft >= :lft ");
		finder.setParam("lft", cur.getLft());
		finder.append(" and a.parent.rgt <= :rgt");
		finder.setParam("rgt", cur.getRgt());
		Long size = dao.countQuery(finder);
		cur.setNums(size);
	}

	public Integer updateNumsAndTime(Integer id) {
		if (id == null) {
			return 0;
		}
		Integer result = 0;
		Menu cur = findById(id);
		if (cur == null) {
			return result;
		}
		do {
			counts(cur);
			cur.setLastDate(new Date());
			cur = cur.getParent();
			result++;
		} while (cur != null);

		return result;
	}

}