package com.ada.approve.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.approve.entity.Task;
public class TaskPage extends PageRpc<Task> {

	public TaskPage(Pagination<Task> page) {
		super(page);
	}

}
