package com.ada.feed.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.feed.entity.FeedTemplate;
public class FeedTemplatePage extends PageRpc<FeedTemplate> {

	public FeedTemplatePage(Pagination<FeedTemplate> page) {
		super(page);
	}

}
