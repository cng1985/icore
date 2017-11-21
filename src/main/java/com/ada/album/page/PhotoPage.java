package com.ada.album.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.album.entity.Photo;
public class PhotoPage extends PageRpc<Photo> {

	public PhotoPage(Pagination<Photo> page) {
		super(page);
	}

}
