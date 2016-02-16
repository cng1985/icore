package com.ada.approve.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.approve.entity.Task;
public class TaskPage extends PageRpc<Task> {

	public TaskPage(Pagination<Task> page) {
		super(page);
	}

}
