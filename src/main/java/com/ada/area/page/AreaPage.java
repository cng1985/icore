package com.ada.area.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.area.entity.Area;
public class AreaPage extends PageRpc<Area> {

	public AreaPage(Pagination<Area> page) {
		super(page);
	}

}
