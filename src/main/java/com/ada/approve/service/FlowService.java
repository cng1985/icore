package com.ada.approve.service;

import java.util.List;

import com.ada.approve.entity.Flow;
import com.ada.approve.page.FlowPage;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import com.quhaodian.data.rest.domain.AbstractVo;

public interface FlowService {

	Flow findById(Long id);

	Flow save(Flow bean);

	/**
	 * 启动一个流程
	 * 
	 * @param bean
	 * @return
	 */
	Flow start(Flow bean);

	/**
	 * 审批
	 * 
	 * @param taskid
	 *            任务id
	 * @param state
	 *            审批状态
	 * @param note
	 *            审批意见
	 * @param user
	 *            员工id
	 * 
	 * @return 审批状态
	 */
	AbstractVo approve(Long taskid, Integer state, String note, Long user);
	
	AbstractVo restart(Long taskid);


	Flow update(Flow bean);

	Flow deleteById(Long id);

	Flow[] deleteByIds(Long[] ids);

	FlowPage getPage(int pageNo, int pageSize);

	Page<Flow> findPage(Pageable pageable);

	long count(Filter... filters);

	List<Flow> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);

}