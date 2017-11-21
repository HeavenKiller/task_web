package com.xwsxjt.domain; /**
 * @Project: zyht_web
 * @Package com.domain
 * @author xiaoshijie
 * @date 2017/8/16 14:23
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xwsxjt.base.domain.IdEntity;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author xiaoshijie
 * @ClassName PackageInformation
 * @Description 套餐信息类
 * @date 2017/8/16
 */
//@Alias("packageInformation")
public class PackageInformation extends IdEntity<Long> {
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
     * 套餐与客户之间是一对多的关系，客户List集合
     */
    private List<Customer> customerList;
    /**
     * 套餐与套餐购买信息之间是一对多的关系，套餐购买List集合
     */
    private List<PackPurInformation> packPurInformationList;

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

    @Override
    public String toString() {
        return "PackageInformation{" +
                "id='" + getId() + '\'' +
                ",mealNumber='" + mealNumber + '\'' +
                ", mealName='" + mealName + '\'' +
                ", mealDescribe='" + mealDescribe + '\'' +
                ", messageNumber=" + messageNumber +
                ", minuteNumber=" + minuteNumber +
                ", flowNumber=" + flowNumber +
                ", isCall=" + isCall +
                ", isColorBack=" + isColorBack +
                ", monthlyRent=" + monthlyRent +
                ", unit=" + unit +
                ", mealStartDate=" + mealStartDate +
                ", mealEndDate=" + mealEndDate +
                '}';
    }

    //    /**
//     * @Title: toString
//     * @Description: 重新toString方法，然后输出对象属性
//     * @author xiaoshijie
//     * @date 2017-08-17
//     * @return String
//     */
//    @Override
//    public String toString(){
//        return ("套餐ID:"+getId()
//                +"套餐编号:"+mealNumber
//                +"; 套餐名称:"+mealName
//                +"; 短信条数:"+messageNumber
//                +"; 花费分钟数:"+minuteNumber
//                +"; 流量数:"+flowNumber+"MB"
//                +"; 是否彩铃:"+isColorBack
//                +"; 月租:"+monthlyRent
//                +"; 开始时间:"+ DateFormatUtils.showDateByFormat(mealStartDate, DateFormatUtils.YEAR_MONTH_DAY)
//                +"; 结束时间:"+ DateFormatUtils.showDateByFormat(mealEndDate, DateFormatUtils.YEAR_MONTH_DAY));
//    }
}

