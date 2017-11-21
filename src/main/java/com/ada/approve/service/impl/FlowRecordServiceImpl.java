package com.ada.approve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.ada.approve.dao.FlowRecordDao;
import com.ada.approve.entity.FlowRecord;
import com.ada.approve.service.FlowRecordService;
import com.ada.approve.page.FlowRecordPage;

import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;

@Service
@Transactional
public class FlowRecordServiceImpl implements FlowRecordService {

	@Transactional(readOnly = true)
	public FlowRecord findById(Long id) {
		FlowRecord entity = dao.findById(id);
		return entity;
	}

	@Transactional
	public FlowRecord save(FlowRecord bean) {
		dao.save(bean);
		return bean;
	}

	@Transactional
	public FlowRecord update(FlowRecord bean) {
		Updater<FlowRecord> updater = new Updater<FlowRecord>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public FlowRecord deleteById(Long id) {
		FlowRecord bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public FlowRecord[] deleteByIds(Long[] ids) {
		FlowRecord[] beans = new FlowRecord[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private FlowRecordDao dao;

	@Autowired
	public void setDao(FlowRecordDao dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	public FlowRecordPage getPage(int pageNo, int pageSize) {
		FlowRecordPage result = null;
		Finder finder = Finder.create();
		finder.append("from FlowRecord f ");
		finder.append(" order by f.id desc  ");
		Pagination<FlowRecord> page = dao.find(finder, pageNo, pageSize);
		result = new FlowRecordPage(page);
		return result;
	}

	@Transactional(readOnly = true)
	public Page<FlowRecord> findPage(Pageable pageable) {
		return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters) {

		return dao.count(filters);

	}

	@Transactional(readOnly = true)
	public List<FlowRecord> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders) {

		return dao.findList(first, count, filters, orders);

	}

	@Override
	public List<FlowRecord> findByFlow(Long flow) {
		Finder finder = Finder.create();
		finder.append("from FlowRecord f where f.flow.id=:flow order by f.id desc ");
		finder.setParam("flow", flow);
		return dao.find(finder);
	}

	@Override
	public List<FlowRecord> findByObjectId(Long id, Integer catalog) {
		Finder finder = Finder.create();
		finder.append("from FlowRecord f where f.flow.oid=:id  and f.flow.catalog=:catalog  order by f.id desc ");
		finder.setParam("id", id);
		finder.setParam("catalog", catalog);
		return dao.find(finder);
	}
}