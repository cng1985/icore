package com.ada.plugin.api;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.stereotype.Component;

import com.ada.plugin.entity.PluginConfig;
import com.ada.plugin.service.PluginConfigService;
import com.ada.plugin.vo.PushBack;

public abstract class PushPlugin extends IPlugin{

	
	/**
	 * 给所有人推送消息
	 * @param msg 消息
	 * @return
	 */
	public abstract PushBack pushAll(String msg,Map<String,String> keys);

	public abstract PushBack pushToSingleDevice(String chanel,String msg,Map<String,String> keys);
	
	public abstract PushBack pushToTag(String tag,String msg,Map<String,String> keys);
	
	
	public abstract PushBack pushToChannels(String[] chanels,String msg,Map<String,String> keys);


	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		StoragePlugin other = (StoragePlugin) obj;
		return new EqualsBuilder().append(getId(), other.getId()).isEquals();
	}

}
