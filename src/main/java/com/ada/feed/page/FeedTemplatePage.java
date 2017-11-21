package com.ada.feed.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.feed.entity.FeedTemplate;
public class FeedTemplatePage extends PageRpc<FeedTemplate> {

	public FeedTemplatePage(Pagination<FeedTemplate> page) {
		super(page);
	}

}
