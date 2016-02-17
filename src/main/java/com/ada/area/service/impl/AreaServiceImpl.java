package com.ada.area.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.area.dao.AreaDao;
import com.ada.area.entity.Area;
import com.ada.area.page.AreaPage;
import com.ada.area.service.AreaService;
import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;

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
		result = (List<Area>) dao.find(finder, 0, id).getList();

		return result;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Area> findByTops(Integer id) {
		LinkedList<Area> areas = new LinkedList<Area>();
		int areaid = id;
		Area area = dao.findById(id);
		while (area.getParent() != null && area.getParent().getId() > 1) {
			areas.addFirst(area);
			area = dao.findById(area.getParentId());
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
}