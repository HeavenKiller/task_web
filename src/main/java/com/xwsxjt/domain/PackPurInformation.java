package com.xwsxjt.domain; /**
 * @Project: zyht_web
 * @Package com.domain
 * @author xiaoshijie
 * @date 2017/8/16 14:34
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xwsxjt.base.domain.IdEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author xiaoshijie
 * @ClassName PackPurInformation
 * @Description 套餐购买信息类
 * @date 2017/8/16
 */
public class PackPurInformation extends IdEntity<Long> {
    /**
     * buyTime--套餐购买日期(yyyy-MM-dd HH:mm:ss)
     */
    @DateTimeFormat(style = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date buyTime;
    /**
     * customer--客户
     */
    private Customer customer;
    /**
     * packageInformation--套餐信息
     */
    private PackageInformation packageInformation;
    /**
     * amountOfPayment--支付金额
     */
    private Double amountOfPayment;
    /**
     * isSuccess--是否购买成功:true(成功);false(失败)
     */
    private Boolean isSuccess;
    /**
     * effectTime--套餐执行时间(yyyy-MM-dd HH:mm:ss)
     */
    @DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date effectTime;

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public PackageInformation getPackageInformation() {
        return packageInformation;
    }

    public void setPackageInformation(PackageInformation packageInformation) {
        this.packageInformation = packageInformation;
    }

    public Double getAmountOfPayment() {
        return amountOfPayment;
    }

    public void setAmountOfPayment(Double amountOfPayment) {
        this.amountOfPayment = amountOfPayment;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Date getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(Date effectTime) {
        this.effectTime = effectTime;
    }

}

