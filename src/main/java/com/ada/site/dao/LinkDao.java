package com.ada.site.dao;


import  com.ada.data.core.CriteriaDao;
import  com.ada.data.core.Updater;
import  com.ada.site.entity.Link;

/**
* Created by imake on 2017年06月07日16:23:50.
*/
public interface LinkDao extends CriteriaDao<Link,Long>{

	public Link findById(Long id);

	public Link save(Link bean);

	public Link updateByUpdater(Updater<Link> updater);

	public Link deleteById(Long id);
}