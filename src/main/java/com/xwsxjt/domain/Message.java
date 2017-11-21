package com.xwsxjt.domain; /**
 * @Project: taskdata
 * @Package entity
 * @author xiaoshijie
 * @date 2017/8/21 15:41
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xwsxjt.base.domain.IdEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author xiaoshijie
 * @ClassName Message
 * @Description 短信信息类
 * @date 2017/8/21
 */
public class Message extends IdEntity<Long> {
    /**
     * sendCustomer--发送者
     */
    private Customer sendCustomer;
    /**
     * receiveCustomer--接收者
     */
    private Customer receiveCustomer;

    /**
     * consumption--发送短信所需的费用,接收短信不需要消费金钱，只有发送短信需要消费金钱
     */
    private Double consumption;
    /**
     * sendMessageTime--发送时间：yyyy-MM-dd HH:mm:ss
     */
    @DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date sendMessageTime;
    /**
     * receiveMessageTime--接收时间：yyyy-MM-dd HH:mm:ss
     */
    private Date receiveMessageTime;
    /**
     * messageType--所发送或接收短信的类型：0-彩信，1-短信，其他待以后扩展
     */
    private Byte messageType;
    /**
     * isSendSuccess--是否发送成功：false(失败),true(成功)
     */
    private Boolean isSendSuccess;
    /**
     * messageContent--短信内容，不超度250字
     */
    private String messageContent;

    public Customer getSendCustomer() {
        return sendCustomer;
    }

    public void setSendCustomer(Customer sendCustomer) {
        this.sendCustomer = sendCustomer;
    }

    public Customer getReceiveCustomer() {
        return receiveCustomer;
    }

    public void setReceiveCustomer(Customer receiveCustomer) {
        this.receiveCustomer = receiveCustomer;
    }

    public Double getConsumption() {
        return consumption;
    }

    public void setConsumption(Double consumption) {
        this.consumption = consumption;
    }

    public Date getSendMessageTime() {
        return sendMessageTime;
    }

    public void setSendMessageTime(Date sendMessageTime) {
        this.sendMessageTime = sendMessageTime;
    }

    public Date getReceiveMessageTime() {
        return receiveMessageTime;
    }

    public void setReceiveMessageTime(Date receiveMessageTime) {
        this.receiveMessageTime = receiveMessageTime;
    }

    public Byte getMessageType() {
        return messageType;
    }

    public void setMessageType(Byte messageType) {
        this.messageType = messageType;
    }

    public Boolean getIsSendSuccess() {
        return isSendSuccess;
    }

    public void setIsSendSuccess(Boolean isSendSuccess) {
        this.isSendSuccess = isSendSuccess;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

}

