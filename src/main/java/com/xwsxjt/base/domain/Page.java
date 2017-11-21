package com.xwsxjt.base.domain; /**
 * @Project: zyht_web
 * @Package com.base.com.domain
 * @author xiaoshijie
 * @date 2017/9/20 22:18
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author xiaoshijie
 * @ClassName Page
 * @Description 分页信息类
 * @date 2017/9/20
 */
public class Page {
    /**
     * 当前页
     */
    private Integer pageNow;
    /**
     * 总页数
     */
    private Integer pageCount;
    /**
     * 总记录数
     */
    private Integer rowCount;
    /**
     * 每页记录数
     */
    private Integer pageSize;
    /**
     * 当前页数的初始条数
     */
    private Integer pageNowCounts;
    /**
     * @Title: getPageCountByRowCountAndPageSize
     * @Description: 根据pageSize和rowCount获得pageCount
     * @author xiaoshijie
     * @date 2017-09-20
     * @param rowCount 总记录数
     * @param pageSize 每页记录数
     * @return Integer
     */
    public static int getPageCountByRowCountAndPageSize(Integer rowCount, Integer pageSize){
        //如果rowCount和pageSize不为空
        if (rowCount != null && pageSize != null){
            //返回pageCount
            return (rowCount.intValue()-1)/pageSize.intValue()+1;
        }
        //为空则返回1
        return 1;
    }

    /**
     * @Title: getPageNowCountsByPageNowAndPageSize
     * @Description: 根据pageSize和pageNow获得pageNowCounts
     * @author xiaoshijie
     * @date 2017-10-25
     * @param pageNow 当前页
     * @param pageSize 每页记录数
     * @return int
     */
    public static int getPageNowCountsByPageNowAndPageSize(Integer pageNow, Integer pageSize){
        //如何pageNow和pageSize不为空
        if (pageNow != null && pageSize != null){
            //返回pageNowCounts
            return (pageNow.intValue()-1)*pageSize.intValue();
        }
        //为空则返回0
        return 0;
    }

    /**
     * @Title: checkOrInitPage
     * @Description: 检查或者初始化Page对象
     * @author xiaoshijie
     * @date 2017-09-23
     * @param page 分页对象
     */
    public static void checkOrInitPage(Page page){
        //如果page为空
        if (page == null){
            //初始化page
            page = new Page();
            page.setPageNow(1);
            page.setPageSize(20);
        }else {
            //如果当前页为空，初始化当前页
            if(page.getPageNow() == null || page.getPageNow() <= 0){
                page.setPageNow(1);
            }
            //如果每页记录数为空，初始化每页记录数
            if (page.getPageSize() == null){
                page.setPageSize(20);
            }
        }
    }

    public Integer getPageNow() {
        return pageNow;
    }

    public void setPageNow(Integer pageNow) {
        this.pageNow = pageNow;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNowCounts() {
        return pageNowCounts;
    }

    public void setPageNowCounts(Integer pageNowCounts) {
        this.pageNowCounts = pageNowCounts;
    }
}

