package com.xwsxjt.domain; /**
 * @Project: taskdata
 * @Package entity
 * @author xiaoshijie
 * @date 2017/8/21 15:39
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import com.xwsxjt.base.domain.IdEntity;
import org.apache.ibatis.type.Alias;

import java.util.List;
import java.util.Set;

/**
 * @author xiaoshijie
 * @ClassName Customer
 * @Description 客户信息类
 * @date 2017/8/21
 */
//@Alias("customer")
public class Customer extends IdEntity<Long> {
    /**
     * name--客户姓名
     */
    private String name;
    /**
     * phoneCode--电话号码
     */
    private String phoneCode;
    /**
     * sex--性别:1-男;0-女
     */
    private Byte sex;
    /**
     * idCard--身份证号
     */
    private String idCard;
    /**
     * address--家庭住址
     */
    private String address;
    /**
     * balance--余额
     */
    private Double balance;
    /**
     * packageInformationId--套餐信息
     */
    private PackageInformation packageInformation;
    /**
     * isShutDown--是否停机
     */
    private Boolean isShutdown;
    /**
     * isStopArrears--是否欠费
     */
    private Boolean isStopArrears;
    /**
     * starStates--星级:1-一星级,2-二星级,3-三星级,4-四星级,5-五星级,6-超级vip
     */
    private Byte starStates;
    /**
     * 客户短信List集合(客户和短信之间是一对多关系)
     */
    private List<Message> messageList = null;
    /**
     * 客户通话记录List集合(客户和通话记录之间是一对多的关系)
     */
    private List<TelephoneInformation> telephoneInformationList = null;
    /**
     * 客户购买套餐记录List集合(客户和套餐购买记录之间是一对多的关系)
     */
    private List<PackPurInformation> packPurInformationList = null;

    public Customer(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public PackageInformation getPackageInformation() {
        return packageInformation;
    }

    public void setPackageInformation(PackageInformation packageInformation) {
        this.packageInformation = packageInformation;
    }

    public Boolean getIsShutdown() {
        return isShutdown;
    }

    public void setIsShutdown(Boolean isShutdown) {
        this.isShutdown = isShutdown;
    }

    public Boolean getIsStopArrears() {
        return isStopArrears;
    }

    public void setIsStopArrears(Boolean isStopArrears) {
        this.isStopArrears = isStopArrears;
    }

    public Byte getStarStates() {
        return starStates;
    }

    public void setStarStates(Byte starStates) {
        this.starStates = starStates;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public List<TelephoneInformation> getTelephoneInformationList() {
        return telephoneInformationList;
    }

    public void setTelephoneInformationList(List<TelephoneInformation> telephoneInformationList) {
        this.telephoneInformationList = telephoneInformationList;
    }

    public List<PackPurInformation> getPackPurInformationList() {
        return packPurInformationList;
    }

    public void setPackPurInformationList(List<PackPurInformation> packPurInformationList) {
        this.packPurInformationList = packPurInformationList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                ", phoneCode='" + phoneCode + '\'' +
                ", sex=" + sex +
                ", idCard='" + idCard + '\'' +
                ", address='" + address + '\'' +
                ", balance=" + balance +
                ", packageInformation=" + packageInformation +
                ", isShutdown=" + isShutdown +
                ", isStopArrears=" + isStopArrears +
                ", starStates=" + starStates +
                '}';
    }
}

