package com.xwsxjt.vo; /**
 * @Project: task-web
 * @Package com.xwsxjt.vo
 * @author xiaoshijie
 * @date 2017/10/29 18:32
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author xiaoshijie
 * @ClassName PackPurInfoVo
 * @Description 套餐购买Vo
 * @date 2017/10/29
 */
public class PackPurInfoVo {
    /**
     * 套餐购买记录ID
     */
    private Long packPurInfoId;
    /**
     * 套餐信息ID
     */
    private Long packInfoId;
    /**
     * 客户电话号码
     */
    private String phoneCode;
    /**
     * 当前页
     */
    private Integer pageNow;

    public Long getPackInfoId() {
        return packInfoId;
    }

    public void setPackInfoId(Long packInfoId) {
        this.packInfoId = packInfoId;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public Integer getPageNow() {
        return pageNow;
    }

    public void setPageNow(Integer pageNow) {
        this.pageNow = pageNow;
    }

    public Long getPackPurInfoId() {
        return packPurInfoId;
    }

    public void setPackPurInfoId(Long packPurInfoId) {
        this.packPurInfoId = packPurInfoId;
    }
}

