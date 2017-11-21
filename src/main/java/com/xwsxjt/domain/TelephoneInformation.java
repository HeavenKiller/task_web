package com.xwsxjt.domain; /**
 * @Project: task_data
 * @Package entity
 * @author xiaoshijie
 * @date 2017/8/17 20:05
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xwsxjt.base.domain.IdEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author xiaoshijie
 * @ClassName TelephoneInformation
 * @Description 电话信息类
 * @date 2017/8/17
 */
public class TelephoneInformation extends IdEntity<Long> {
    /**
     *dialCustomer--拨打用户
     */
    private Customer dialCustomer;
    /**
     * answerCustomer--接听用户
     */
    private Customer answerCustomer;
    /**
     * conversationTime--接听时间
     */
    private Long conversationTime;
    /**
     * callConsumption--通话扣除的电话费
     */
    private Double callConsumption;
    /**
     * callBeginTime--通话开始时间 yyyy-MM-dd HH:mm:ss
     */
    @DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date callBeginTime;
    /**
     * callEndTime--通话结束时间 yyyy-MM-dd HH:mm:ss
     */
    @DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date callEndTime;
    /**
     * callType--通话类型:1-本地,2-长途,3-漫游
     */
    private Byte callType;
    /**
     * answerState--是否通话成功:false-未成功,true-成功
     */
    private Boolean isCallSuccess;
    /**
     * dialType--拨打类型:true-拨打,false-接听
     */
    private Boolean dialType;

    public Customer getDialCustomer() {
        return dialCustomer;
    }

    public void setDialCustomer(Customer dialCustomer) {
        this.dialCustomer = dialCustomer;
    }

    public Customer getAnswerCustomer() {
        return answerCustomer;
    }

    public void setAnswerCustomer(Customer answerCustomer) {
        this.answerCustomer = answerCustomer;
    }

    public Long getConversationTime() {
        return conversationTime;
    }

    public void setConversationTime(Long conversationTime) {
        this.conversationTime = conversationTime;
    }

    public Double getCallConsumption() {
        return callConsumption;
    }

    public void setCallConsumption(Double callConsumption) {
        this.callConsumption = callConsumption;
    }

    public Date getCallBeginTime() {
        return callBeginTime;
    }

    public void setCallBeginTime(Date callBeginTime) {
        this.callBeginTime = callBeginTime;
    }

    public Date getCallEndTime() {
        return callEndTime;
    }

    public void setCallEndTime(Date callEndTime) {
        this.callEndTime = callEndTime;
    }

    public Byte getCallType() {
        return callType;
    }

    public void setCallType(Byte callType) {
        this.callType = callType;
    }

    public Boolean getIsCallSuccess() {
        return isCallSuccess;
    }

    public void setIsCallSuccess(Boolean isCallSuccess) {
        this.isCallSuccess = isCallSuccess;
    }

    public Boolean getDialType() {
        return dialType;
    }

    public void setDialType(Boolean dialType) {
        this.dialType = dialType;
    }

}

