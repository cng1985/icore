package com.ada.feed.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.feed.dto.FeedDto;

public class FeedDtoPage extends PageRpc<FeedDto> {

	public FeedDtoPage(Pagination<FeedDto> page) {
		super(page);
	}
	public FeedDtoPage() {
	}

}
