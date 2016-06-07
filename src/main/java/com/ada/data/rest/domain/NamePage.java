package com.ada.data.rest.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 简单返回名字+id的集合
 * 
 * @author 73552
 *
 */
public class NamePage implements Serializable {

	private int code;

	private List<NameSimple> list;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public List<NameSimple> getList() {
		return list;
	}

	public void setList(List<NameSimple> list) {
		this.list = list;
	}

}
