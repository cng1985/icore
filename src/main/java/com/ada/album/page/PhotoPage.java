package com.ada.album.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.album.entity.Photo;
public class PhotoPage extends PageRpc<Photo> {

	public PhotoPage(Pagination<Photo> page) {
		super(page);
	}

}
