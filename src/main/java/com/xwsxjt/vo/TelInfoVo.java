package com.xwsxjt.vo; /**
 * @Project: task-web
 * @Package com.xwsxjt.vo
 * @author xiaoshijie
 * @date 2017/10/31 15:29
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author xiaoshijie
 * @ClassName CustomerVo
 * @Description 客户Vo
 * @date 2017/10/31
 */
public class TelInfoVo {
    private Long answerCustomerId;
    private String phoneCode;
    private Long telInfoId;

    public Long getAnswerCustomerId() {
        return answerCustomerId;
    }

    public void setAnswerCustomerId(Long answerCustomerId) {
        this.answerCustomerId = answerCustomerId;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public Long getTelInfoId() {
        return telInfoId;
    }

    public void setTelInfoId(Long telInfoId) {
        this.telInfoId = telInfoId;
    }
}

