package com.ada.plugin.service;

import com.ada.plugin.entity.PluginConfig;
import com.ada.plugin.page.PluginConfigPage;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import java.util.List;


public interface PluginConfigService {

	PluginConfig findById(Long id);

	PluginConfig save(PluginConfig bean);

	PluginConfig update(PluginConfig bean);

	PluginConfig deleteById(Long id);
	
	PluginConfig[] deleteByIds(Long[] ids);
	
	PluginConfigPage getPage(int pageNo, int pageSize);
	
	
	Page<PluginConfig> findPage(Pageable pageable);

	long count(Filter... filters);

	List<PluginConfig> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);

	boolean pluginIdExists(String id);

	PluginConfig findByPluginId(String id);
	
}