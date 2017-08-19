package com.ada.site.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import  com.ada.site.entity.LinkType;

/**
* Created by imake on 2017年06月07日16:23:50.
*/
public interface LinkTypeDao extends CriteriaDao<LinkType,Integer>{

	public LinkType findById(Integer id);

	public LinkType save(LinkType bean);

	public LinkType updateByUpdater(Updater<LinkType> updater);

	public LinkType deleteById(Integer id);
}