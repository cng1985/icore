package com.ada.approve.service;

import com.ada.approve.entity.Task;
import com.ada.approve.page.TaskPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

import com.openyelp.annotation.RestFul;

@RestFul(api=TaskService.class,value="TaskService")
public interface TaskService {

	public Task findById(Long id);

	public Task save(Task bean);

	public Task update(Task bean);

	public Task deleteById(Long id);
	
	public Task[] deleteByIds(Long[] ids);
	
	public TaskPage getPage(int pageNo, int pageSize);
	
	
	public Page<Task> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<Task> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);
	
}