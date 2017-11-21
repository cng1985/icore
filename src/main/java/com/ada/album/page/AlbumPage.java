package com.ada.album.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.album.entity.Album;
public class AlbumPage extends PageRpc<Album> {

	public AlbumPage(Pagination<Album> page) {
		super(page);
	}

}
