package com.ada.feed.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.feed.entity.FeedComment;
public class FeedCommentPage extends PageRpc<FeedComment> {

	public FeedCommentPage(Pagination<FeedComment> page) {
		super(page);
	}

}
