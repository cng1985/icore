package com.quhaodian.data.dto;

import com.quhaodian.data.core.Pagination;

import java.io.Serializable;
import java.util.List;

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
    /**
     * 第一条数据位置
     *
     * @return
     */
    public int getFirstResult() {
        return (pageNo - 1) * pageSize;
    }
    /**
     * 第一条数据位置
     *
     * @return
     */
    public int getFirstNo() {
        int result=1;
        result=pageNo-size;

        int t=getEndNo()-result;
        int num=size*2;
        if(t<num){
            result=result-(num-t);
        }
        if(result<=0){
            result=1;
        }
        return result;
    }
    int size=2;
    /**
     * 第一条数据位置
     *
     * @return
     */
    public int getEndNo() {
        int result=1;
        result=getPageNo()+size;

        if(getPageNo()<=size){
            result=result+size-getPageNo();
            result++;
        }else{
        }


        if(result>getTotalPage()){
            result=getTotalPage();
        }
        return result;
    }
    /**
     * 总共几页
     */
    public int getTotalPage() {
        int totalPage = total / pageSize;
        if (totalPage == 0 || total % pageSize != 0) {
            totalPage++;
        }
        return totalPage;
    }

    /**
     * 是否最后一页
     */
    public boolean isLastPage() {
        return pageNo >= getTotalPage();
    }

    /**
     * 下一页页码
     */
    public int getNextPage() {
        if (isLastPage()) {
            return pageNo;
        } else {
            return pageNo + 1;
        }
    }

    /**
     * 上一页页码
     */
    public int getPrePage() {
        if (isFirstPage()) {
            return pageNo;
        } else {
            return pageNo - 1;
        }
    }
    /**
     * 是否第一页
     */
    public boolean isFirstPage() {
        return pageNo <= 1;
    }
    @Override
    public String toString() {
        return "PageRpc [pageNo=" + pageNo + ", pageSize=" + pageSize
                + ", pageTotal=" + pageTotal + ", total=" + total + ", list="
                + list + "]";
    }

}
