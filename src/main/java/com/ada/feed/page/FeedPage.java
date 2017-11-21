package com.ada.feed.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.feed.entity.Feed;
public class FeedPage extends PageRpc<Feed> {

	public FeedPage(Pagination<Feed> page) {
		super(page);
	}

}
