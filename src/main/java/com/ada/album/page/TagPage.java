package com.ada.album.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.album.entity.Tag;
public class TagPage extends PageRpc<Tag> {

	public TagPage(Pagination<Tag> page) {
		super(page);
	}

}
