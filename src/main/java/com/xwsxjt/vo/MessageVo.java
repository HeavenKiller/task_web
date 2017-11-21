package com.xwsxjt.vo; /**
 * @Project: task-web
 * @Package com.xwsxjt.vo
 * @author xiaoshijie
 * @date 2017/10/31 19:48
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author xiaoshijie
 * @ClassName MessageVo
 * @Description 短信Vo类
 * @date 2017/10/31
 */
public class MessageVo {
    private String phoneCode;
    private Long messageId;
    private Long receiveCustomerId;
    private Byte messageType;
    private String messageContent;

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public Long getReceiveCustomerId() {
        return receiveCustomerId;
    }

    public void setReceiveCustomerId(Long receiveCustomerId) {
        this.receiveCustomerId = receiveCustomerId;
    }

    public Byte getMessageType() {
        return messageType;
    }

    public void setMessageType(Byte messageType) {
        this.messageType = messageType;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }
}

