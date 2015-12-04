package com.ada.plugin.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.ada.plugin.entity.PluginConfig;
public class PluginConfigPage extends PageRpc<PluginConfig> {

	public PluginConfigPage(Pagination<PluginConfig> page) {
		super(page);
	}

}
