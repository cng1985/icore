package com.ada.plugin.dao;


import  com.quhaodian.data.core.CriteriaDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import  com.ada.plugin.entity.PluginConfig;

public interface PluginConfigDao extends CriteriaDao<PluginConfig, Long>{
	Pagination getPage(int pageNo, int pageSize);

	PluginConfig findById(Long id);

	PluginConfig save(PluginConfig bean);

	PluginConfig updateByUpdater(Updater<PluginConfig> updater);

	PluginConfig deleteById(Long id);
}