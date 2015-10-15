package com.ada.feed.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.feed.entity.FeedComment;
public class FeedCommentPage extends PageRpc<FeedComment> {

	public FeedCommentPage(Pagination<FeedComment> page) {
		super(page);
	}

}
