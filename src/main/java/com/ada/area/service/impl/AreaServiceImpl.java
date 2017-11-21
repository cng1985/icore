package com.ada.area.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.area.dao.AreaDao;
import com.ada.area.entity.Area;
import com.ada.area.page.AreaPage;
import com.ada.area.service.AreaService;
import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;

@Service
@Transactional
public class AreaServiceImpl implements AreaService {

	@Transactional(readOnly = true)
	public Area findById(Integer id) {
		Area entity = dao.findById(id);
		return entity;
	}

	@Transactional
	public Area save(Area bean) {
		dao.save(bean);
		return bean;
	}

	@Transactional
	public Area update(Area bean) {
		Updater<Area> updater = new Updater<Area>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public Area deleteById(Integer id) {
		Area bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public Area[] deleteByIds(Integer[] ids) {
		Area[] beans = new Area[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private AreaDao dao;

	@Autowired
	public void setDao(AreaDao dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	public AreaPage getPage(int pageNo, int pageSize) {
		AreaPage result = null;
		Pagination<Area> page = dao.getPage(pageNo, pageSize);
		result = new AreaPage(page);
		return result;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Area> findByLevel(Integer id) {
		// TODO Auto-generated method stub
		return dao.findByProperty("levelinfo", id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Area> findByParent(Integer id) {
		// TODO Auto-generated method stub
		return dao.findByProperty("parent.id", id);
	}

	@Override
	public List<Area> findByHot(Integer id) {
		List<Area> result = null;
		Finder finder = Finder.create();
		finder.append("select h.area from AreaHot h");
		dao.find(finder, 0, id);
		result = dao.find(finder, 0, id).getList();

		return result;
	}

	@Override
	public Page<Area> page(Pageable pageable) {
		return dao.page(pageable);
	}

	@Transactional(readOnly = true)
	@Override
	public Area findByName(String name) {

		Area resultone = null;

		List<Area> result = null;
		Finder finder = Finder.create();
		finder.append(" from Area a  where a.name=:name");
		finder.setParam("name", name);
		result = dao.find(finder);
		if (result != null && result.size() > 0) {
			resultone = result.get(0);
		}
		return resultone;
	}

	@Transactional(readOnly = true)
	@Override
	public Area findByNames(String name) {
		Area resultone = null;
		name = "%" + name + "%";
		List<Area> result = null;
		Finder finder = Finder.create();
		finder.append(" from Area a  where a.name  like :name");
		finder.setParam("name", name);
		result = dao.find(finder);
		if (result != null && result.size() > 0) {
			resultone = result.get(0);
		}
		return resultone;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Area> findByChild(Integer id) {
		List ms = null;
		Area menu = dao.findById(id);
		if (menu != null) {
			Finder finder = Finder.create("from Area t where t.lft >:lft and t.rgt<:rgt ");
			finder.append(" order by t.lft asc");
			finder.setParam("lft", menu.getLft());
			finder.setParam("rgt", menu.getRgt());
			finder.setCacheable(false);
			ms = dao.find(finder);
		}
		return ms;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Area> findByTops(Integer id) {
		LinkedList<Area> areas = new LinkedList<Area>();
		Area area = dao.findById(id);
		while (area.getParent() != null && area.getId() > 0) {
			areas.addFirst(area);
			area = dao.findById(area.getParentId());
		}

		if (area != null && area.getId() != null) {
			areas.addFirst(area);
		}

		return areas;
	}

	@Override
	public Page<Area> findPage(Pageable pageable) {
		return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Area> findByPids() {

		List<Area> result = null;
		Finder finder = Finder.create();
		finder.append(" from Area a  where a.parent is null");
		result = dao.find(finder);

		return result;
	}

	@Cacheable(value = "area_cache")
	@Transactional(readOnly = true)
	@Override
	public AreaPage pageByLevel(int level, int pageNo, int pageSize) {
		Finder finder = Finder.create();
		finder.append("from Area a where a.levelinfo =:levelinfo");
		finder.setParam("levelinfo", level);
		finder.append(" order by a.id desc ");
		return new AreaPage(dao.find(finder, pageNo, pageSize));
	}

	@Cacheable(value = "area_cache")
	@Transactional(readOnly = true)
	@Override
	public AreaPage pageByLevel(Integer areaid, int level, int pageNo, int pageSize) {
		Area area = dao.findById(areaid);

		Finder finder = Finder.create();
		finder.append("from Area a where a.levelinfo =:levelinfo");
		finder.setParam("levelinfo", level);
		if (area != null) {
			finder.append(" and a.lft>=" + area.getLft());
			finder.append(" and a.rgt<=" + area.getRgt());
		}
		finder.append(" order by a.id desc ");

		return new AreaPage(dao.find(finder, pageNo, pageSize));
	}

	@Cacheable(value = "area_cache")
	@Transactional(readOnly = true)
	@Override
	public AreaPage pageByLevelState(int level, int state, int pageNo, int pageSize) {
		Finder finder = Finder.create();
		finder.append("from Area a where a.levelinfo =:levelinfo");
		finder.setParam("levelinfo", level);
		finder.append(" and a.state =:state");
		finder.setParam("state", state);
		finder.append(" order by a.id desc ");
		return new AreaPage(dao.find(finder, pageNo, pageSize));
	}
	@Transactional
	@Override
	public List<Area> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders) {
		// TODO Auto-generated method stub
		return dao.findList(first, count, filters, orders);
	}

}