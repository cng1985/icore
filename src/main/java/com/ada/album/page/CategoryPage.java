package com.ada.album.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.album.entity.Category;
public class CategoryPage extends PageRpc<Category> {

	public CategoryPage(Pagination<Category> page) {
		super(page);
	}

}
