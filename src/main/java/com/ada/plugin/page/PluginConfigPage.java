package com.ada.plugin.page;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dto.PageRpc;
import com.ada.plugin.entity.PluginConfig;
public class PluginConfigPage extends PageRpc<PluginConfig> {

	public PluginConfigPage(Pagination<PluginConfig> page) {
		super(page);
	}

}
