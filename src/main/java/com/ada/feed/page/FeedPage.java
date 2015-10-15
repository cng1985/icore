package com.ada.feed.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.feed.entity.Feed;
public class FeedPage extends PageRpc<Feed> {

	public FeedPage(Pagination<Feed> page) {
		super(page);
	}

}
