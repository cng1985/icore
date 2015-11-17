package com.ada.album.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.album.entity.Category;
public class CategoryPage extends PageRpc<Category> {

	public CategoryPage(Pagination<Category> page) {
		super(page);
	}

}
