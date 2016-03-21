package com.ada.data.utils;

import com.ada.data.entity.CatalogEntity;

public class CatalogUtils {

	public static void  updateParent(CatalogEntity bean,CatalogEntity parent ){
		if (bean.getParentId() != null) {
			if (parent != null) {
				if (parent.getLevelinfo() != null) {
					bean.setLevelinfo(parent.getLevelinfo() + 1);
				} else {
					parent.setLevelinfo(1);
					bean.setLevelinfo(2);
				}
				if (parent.getIds() != null) {
					bean.setIds(parent.getIds() + "," + bean.getId());
				} else {
					parent.setIds(parent.getId()+"");
					bean.setIds(parent.getId() + "," + bean.getId());
				}
			} else {
				bean.setLevelinfo(1);
				bean.setIds("" + bean.getId());
			}
		} else {
			bean.setLevelinfo(1);
			bean.setIds("" + bean.getId());
		}
	}
}
