package com.lw.utils;

public class FindByPage {
    // 每页显示的数据
   public static final int PAGE_SIZE = 3;
    // 总页数
    int totalPage;
    // 当前页
    int currentPage = 1;
    // 起始位置
    int start;
    public FindByPage(int total, int currentPage){
        // 计算总页数
        if (total % PAGE_SIZE == 0){
            totalPage = total / PAGE_SIZE;
        } else {
            totalPage = total / PAGE_SIZE + 1;
        }
        // 当前页
        // 上一页 下一页
        this.currentPage = currentPage < 1 ? 1 : currentPage > totalPage ? totalPage : currentPage;

        // 计算起始位置
        this.start = (this.currentPage -1)*PAGE_SIZE;
    }


    public int getTotalPage() {
        return totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getStart() {
        return start;
    }
}
