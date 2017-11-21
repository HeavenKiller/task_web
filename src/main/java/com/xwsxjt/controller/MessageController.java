package com.xwsxjt.controller; /**
 * @Project: task-web
 * @Package com.xwsxjt.controller
 * @author xiaoshijie
 * @date 2017/10/31 17:44
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.xwsxjt.base.domain.Page;
import com.xwsxjt.domain.Customer;
import com.xwsxjt.domain.Message;
import com.xwsxjt.service.CustomerService;
import com.xwsxjt.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xwsxjt.vo.MessageVo;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiaoshijie
 * @ClassName MessageController
 * @Description 短信Controller类
 * @date 2017/10/31
 */
@Controller
@RequestMapping(value = "message")
public class MessageController {
    @Resource
    private CustomerService customerService;
    @Resource
    private MessageService messageService;

    @RequestMapping(value = "addMessage.do")
    @ResponseBody
    public Map addMessage(@RequestBody MessageVo messageVo){
        Map<String,Object> resultMap = new HashMap<>();

        if (messageVo.getPhoneCode() == null || messageVo.getPhoneCode() == ""){
            resultMap.put("result", "0");
            return resultMap;
        }
        Map<String,Object> sendCustomerMap = new HashMap<>();
        sendCustomerMap.put("phoneCode", messageVo.getPhoneCode());
        Customer sendCustomer = customerService.getCustomer(sendCustomerMap);
        //如果session中客户不存在，表示session有效期已过，提醒用户重新登录
        if (sendCustomer == null){
            resultMap.put("result", "0");
            return resultMap;
        }

        Map<String,Object> receiveCustomerMap = new HashMap<>();
        receiveCustomerMap.put("id", messageVo.getReceiveCustomerId());
        //获得接收客户
        Customer receiveCustomer = customerService.getCustomer(receiveCustomerMap);

        //设置是否发送成功：1-失败，2-成功
        byte sendState = (byte) ((int)(Math.random()*2)+1);
        Message message = new Message();
        //定义短信费用并初始化
        double consumption = 0d;

        if (sendState == 2){
            message.setIsSendSuccess(true);
            //0-彩信，1-短信
            if (messageVo.getMessageType().byteValue() == 0){
                consumption = 0.15;
            }else if (messageVo.getMessageType().byteValue() == 1){
                consumption = 0.1;
            }
            sendCustomer.setBalance(sendCustomer.getBalance().doubleValue() - consumption);
            customerService.updateCustomer(sendCustomer);
        }else {
            message.setIsSendSuccess(false);
        }

        message.setConsumption(consumption);
        message.setMessageType(messageVo.getMessageType());
        message.setMessageContent(messageVo.getMessageContent());
        message.setReceiveCustomer(receiveCustomer);
        message.setSendCustomer(sendCustomer);
        message.setSendMessageTime(new Date());
        message.setReceiveMessageTime(new Date());

        messageService.saveMessage(message);
        resultMap.put("result", sendState);
        return resultMap;
    }

    @RequestMapping(value = "findMessageList.do")
    @ResponseBody
    public Map findMessageList(@RequestBody MessageVo messageVo){
        //定义结果集
        Map<String,Object> resultMap = new HashMap<>();
        if (messageVo.getPhoneCode() == null || messageVo.getPhoneCode() == ""){
            resultMap.put("result", "0");
            return resultMap;
        }
        Map<String,Object> customerMap = new HashMap<>();
        customerMap.put("phoneCode", messageVo.getPhoneCode());
        Customer customer = customerService.getCustomer(customerMap);
        //如果session中客户不存在，表示session有效期已过，提醒用户重新登录
        if (customer == null){
            resultMap.put("result", "0");
            return resultMap;
        }

        Map<String,Object> pageMap = new HashMap<>();
        Page page = new Page();
        Page.checkOrInitPage(page);
        page.setPageNowCounts(Page.getPageNowCountsByPageNowAndPageSize(page.getPageNow(), page.getPageSize()));
        pageMap.put("pageSize", page.getPageSize());
        pageMap.put("pageNowCounts", page.getPageNowCounts());
        pageMap.put("customerId", customer.getId());
        List<Message> messageList = messageService.findMessageList(pageMap);

        resultMap.put("result", "1");
        resultMap.put("messageList", messageList);

        return resultMap;
    }

    @RequestMapping(value = "deleteMessage.do")
    @ResponseBody
    public Map deleteMessage(@RequestBody MessageVo messageVo){
        //定义结果集
        Map<String,Object> resultMap = new HashMap<>();
        if (messageVo.getPhoneCode() == null || messageVo.getPhoneCode() == ""){
            resultMap.put("result", "请登录");
            return resultMap;
        }
        Map<String,Object> customerMap = new HashMap<>();
        customerMap.put("phoneCode", messageVo.getPhoneCode());
        Customer customer = customerService.getCustomer(customerMap);
        //如果session中客户不存在，表示session有效期已过，提醒用户重新登录
        if (customer == null){
            resultMap.put("result", "请登录");
            return resultMap;
        }

        if (messageService.deleteMessage(messageVo.getMessageId()) > 0){
            resultMap.put("result", "删除成功");
        }else {
            resultMap.put("result", "删除失败");
        }

        return resultMap;
    }
}

