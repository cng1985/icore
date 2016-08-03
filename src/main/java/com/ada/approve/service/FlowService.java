package com.ada.approve.service;

import java.util.List;

import com.ada.approve.entity.Flow;
import com.ada.approve.page.FlowPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import com.ada.data.rest.domain.AbstractVo;
import com.openyelp.annotation.RestFul;

@RestFul(api = FlowService.class, value = "FlowService")
public interface FlowService {

	public Flow findById(Long id);

	public Flow save(Flow bean);

	/**
	 * 启动一个流程
	 * 
	 * @param bean
	 * @return
	 */
	public Flow start(Flow bean);

	/**
	 * 审批
	 * 
	 * @param taskid
	 *            任务id
	 * @param state
	 *            审批状态
	 * @param note
	 *            审批意见
	 * @param workid
	 *            员工id
	 * 
	 * @return 审批状态
	 */
	AbstractVo approve(Long taskid, Integer state, String note, Long user);
	
	AbstractVo restart(Long taskid);


	public Flow update(Flow bean);

	public Flow deleteById(Long id);

	public Flow[] deleteByIds(Long[] ids);

	public FlowPage getPage(int pageNo, int pageSize);

	public Page<Flow> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<Flow> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);

}