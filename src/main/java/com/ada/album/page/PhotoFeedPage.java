package com.ada.album.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.album.entity.PhotoFeed;
public class PhotoFeedPage extends PageRpc<PhotoFeed> {

	public PhotoFeedPage(Pagination<PhotoFeed> page) {
		super(page);
	}

}
