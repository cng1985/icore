package com.ada.plugin.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.ada.plugin.entity.PluginConfig;

public interface PluginConfigDao extends CriteriaDao<PluginConfig, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public PluginConfig findById(Long id);

	public PluginConfig save(PluginConfig bean);

	public PluginConfig updateByUpdater(Updater<PluginConfig> updater);

	public PluginConfig deleteById(Long id);
}