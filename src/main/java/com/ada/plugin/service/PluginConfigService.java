package com.ada.plugin.service;

import com.ada.plugin.entity.PluginConfig;
import com.ada.plugin.page.PluginConfigPage;
import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;

import com.openyelp.annotation.RestFul;

@RestFul(api=PluginConfigService.class,value="PluginConfigService")
public interface PluginConfigService {

	public PluginConfig findById(Long id);

	public PluginConfig save(PluginConfig bean);

	public PluginConfig update(PluginConfig bean);

	public PluginConfig deleteById(Long id);
	
	public PluginConfig[] deleteByIds(Long[] ids);
	
	public PluginConfigPage getPage(int pageNo, int pageSize);
	
	
	public Page<PluginConfig> findPage(Pageable pageable);

	public long count(Filter... filters);

	public List<PluginConfig> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders);

	public boolean pluginIdExists(String id);

	public PluginConfig findByPluginId(String id);
	
}