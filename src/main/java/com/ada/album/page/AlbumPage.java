package com.ada.album.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.album.entity.Album;
public class AlbumPage extends PageRpc<Album> {

	public AlbumPage(Pagination<Album> page) {
		super(page);
	}

}
