package com.lp.mvp_network.second2demo.bean;

/**
 * File descripition:
 *
 * @author lp
 * @date 2019/6/6
 */

public class Bean2 {

    /**
     * totalPage : 0
     * startPage : 1
     * limit : 30
     * total : 0
     * more_items_in_collection : false
     */

    private int totalPage;
    private int startPage;
    private int limit;
    private int total;
    private boolean more_items_in_collection;

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isMore_items_in_collection() {
        return more_items_in_collection;
    }

    public void setMore_items_in_collection(boolean more_items_in_collection) {
        this.more_items_in_collection = more_items_in_collection;
    }
}
