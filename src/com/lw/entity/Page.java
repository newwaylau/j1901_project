package com.lw.entity;

import java.util.List;

public class Page {
    //当前页
    private Integer currentPage = 1;
    //总页数
    private Integer totalPage;
    //数据总行数
    private Integer totalCount;
    //每页展示数
    private Integer pageSize = 3;
    //跳转路径
    private String url;
    //展示数据的集合
    private List<?> list;

    public Page() {
    }

    public Page(Integer currentPage, Integer totalPage, Integer totalCount, Integer pageSize, String url, List<?> list) {
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.url = url;
        this.list = list;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        setTotalPage(totalCount%pageSize == 0 ? totalCount/pageSize : totalCount/pageSize +1);
        this.totalCount = totalCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                ", pageSize=" + pageSize +
                ", url='" + url + '\'' +
                ", list=" + list +
                '}';
    }
}
