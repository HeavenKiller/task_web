package com.xwsxjt.vo; /**
 * @Project: task-web
 * @Package com.xwsxjt.vo
 * @author xiaoshijie
 * @date 2017/10/30 17:41
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.File;
import java.util.Date;

/**
 * @author xiaoshijie
 * @ClassName PackInfoVo
 * @Description 套餐信息Vo类
 * @date 2017/10/30
 */
public class PackInfoVo {
    /**
     * 套餐ID
     */
    private Long packInfoId;
    /**
     * mealNumber--套餐编号
     */
    private String mealNumber;
    /**
     * mealName--套餐名
     */
    private String mealName;
    /**
     * mealDescribe--套餐描述
     */
    private String mealDescribe;
    /**
     * messageNumber--短信条数
     */
    private Integer messageNumber;
    /**
     * minuteNumber--话费分钟数
     */
    private Integer minuteNumber;
    /**
     * flowNumber--流量数
     */
    private Double flowNumber;
    /**
     * isCall--是否来电提醒
     */
    private Boolean isCall;
    /**
     * isColorBack--是否彩铃
     */
    private Boolean isColorBack;
    /**
     * monthlyRent--月租
     */
    private Double monthlyRent;
    /**
     * unit--流量单位:1-KB,2-MB,3-GB,4-TB
     */
    private Byte unit;
    /**
     * mealStartDate--套餐开始时间
     */
    @DateTimeFormat(style = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date mealStartDate;
    /**
     * mealEndDate--套餐结束时间
     */
    @DateTimeFormat(style = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date mealEndDate;
    /**
     * 套餐图片
     */
    private File packInfoImage;

    public Long getPackInfoId() {
        return packInfoId;
    }

    public void setPackInfoId(Long packInfoId) {
        this.packInfoId = packInfoId;
    }

    public String getMealNumber() {
        return mealNumber;
    }

    public void setMealNumber(String mealNumber) {
        this.mealNumber = mealNumber;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealDescribe() {
        return mealDescribe;
    }

    public void setMealDescribe(String mealDescribe) {
        this.mealDescribe = mealDescribe;
    }

    public Integer getMessageNumber() {
        return messageNumber;
    }

    public void setMessageNumber(Integer messageNumber) {
        this.messageNumber = messageNumber;
    }

    public Integer getMinuteNumber() {
        return minuteNumber;
    }

    public void setMinuteNumber(Integer minuteNumber) {
        this.minuteNumber = minuteNumber;
    }

    public Double getFlowNumber() {
        return flowNumber;
    }

    public void setFlowNumber(Double flowNumber) {
        this.flowNumber = flowNumber;
    }

    public Boolean getIsCall() {
        return isCall;
    }

    public void setIsCall(Boolean isCall) {
        this.isCall = isCall;
    }

    public Boolean getIsColorBack() {
        return isColorBack;
    }

    public void setIsColorBack(Boolean isColorBack) {
        this.isColorBack = isColorBack;
    }

    public Double getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(Double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public Byte getUnit() {
        return unit;
    }

    public void setUnit(Byte unit) {
        this.unit = unit;
    }

    public Date getMealStartDate() {
        return mealStartDate;
    }

    public void setMealStartDate(Date mealStartDate) {
        this.mealStartDate = mealStartDate;
    }

    public Date getMealEndDate() {
        return mealEndDate;
    }

    public void setMealEndDate(Date mealEndDate) {
        this.mealEndDate = mealEndDate;
    }

    public File getPackInfoImage() {
        return packInfoImage;
    }

    public void setPackInfoImage(File packInfoImage) {
        this.packInfoImage = packInfoImage;
    }
}

