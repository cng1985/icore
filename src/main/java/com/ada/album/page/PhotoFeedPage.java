package com.ada.album.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.album.entity.PhotoFeed;
public class PhotoFeedPage extends PageRpc<PhotoFeed> {

	public PhotoFeedPage(Pagination<PhotoFeed> page) {
		super(page);
	}

}
