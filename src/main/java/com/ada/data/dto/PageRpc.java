package com.ada.data.dto;

import java.io.Serializable;
import java.util.List;

import com.ada.data.core.Pagination;

public class PageRpc<T> implements Serializable {

	private List<T> list;
	private int pageNo;
	private int pageSize;
	private int pageTotal;

	private int total;
	public PageRpc(){
	}
	//public PageRpc(){}
	public PageRpc(Pagination<T> page){
		
		pageNo=page.getPageNo();
		pageTotal=page.getTotalPage();
		pageSize=page.getPageSize();
		total=page.getTotalCount();
		list=page.getList();
	}
	public void setPage(Pagination<?> page){
		
		pageNo=page.getPageNo();
		pageTotal=page.getTotalPage();
		pageSize=page.getPageSize();
		total=page.getTotalCount();
	}
	public List<T> getList() {
		return list;
	}

	public int getPageNo() {
		return pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public int getTotal() {
		return total;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}


	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "PageRpc [pageNo=" + pageNo + ", pageSize=" + pageSize
				+ ", pageTotal=" + pageTotal + ", total=" + total + ", list="
				+ list + "]";
	}
	
}
