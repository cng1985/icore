package com.ada.approve.service;

import com.ada.approve.entity.Task;
import com.ada.approve.page.TaskPage;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


public interface TaskService {

	Task findById(Long id);

	Task save(Task bean);

	Task update(Task bean);

	Task deleteById(Long id);
	
	Task[] deleteByIds(Long[] ids);
	
	TaskPage getPage(int pageNo, int pageSize);
	
	
	Page<Task> findPage(Pageable pageable);

	long count(Filter... filters);

	List<Task> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}