package com.xwsxjt.controller; /**
 * @Project: task-web
 * @Package com.xwsxjt.controller
 * @author xiaoshijie
 * @date 2017/10/31 15:24
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.xwsxjt.base.domain.Page;
import com.xwsxjt.domain.Customer;
import com.xwsxjt.domain.TelephoneInformation;
import com.xwsxjt.service.CustomerService;
import com.xwsxjt.service.TelephoneInformationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xwsxjt.vo.TelInfoVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiaoshijie
 * @ClassName TelephoneInformationController
 * @Description 通话信息Controller类
 * @date 2017/10/31
 */
@Controller
@RequestMapping(value = "telinfo")
public class TelephoneInformationController {
    @Resource
    private CustomerService customerService;
    @Resource
    private TelephoneInformationService telephoneInformationService;

    @RequestMapping(value = "addTelInfo.do")
    @ResponseBody
    public Map addTelInfo(@RequestBody TelInfoVo telInfoVo, HttpServletRequest request){
        //定义结果集
        Map<String,Object> resultMap = new HashMap<>();
        HttpSession session = request.getSession();

        if (telInfoVo.getPhoneCode() == null || telInfoVo.getPhoneCode() == ""){
            resultMap.put("result", "0");
            return resultMap;
        }
        Map<String,Object> dialMap = new HashMap<>();
        dialMap.put("phoneCode", telInfoVo.getPhoneCode());
        Customer dialCustomer = customerService.getCustomer(dialMap);
        //如果session中客户不存在，表示session有效期已过，提醒用户重新登录
        if (dialCustomer == null){
            resultMap.put("result", "0");
            return resultMap;
        }
        Map<String,Object> answerMap = new HashMap<>();
        answerMap.put("id", telInfoVo.getAnswerCustomerId());
        Customer answerCustomer = customerService.getCustomer(answerMap);
        //设置通话状态:1-未接听；2-接听；3-接听客户停机
        byte answerKind = 1;
        //接听客户是否停机
        boolean isStopArrears = answerCustomer.getIsStopArrears();
        //定义并初始化拨打通话信息
        TelephoneInformation dialTelInfo = new TelephoneInformation();
        //获得拨打时间
        Date callBeginTime = new Date();

        //设置通话类型:1-本地,2-长途,3-漫游
        byte callType = (byte) ((int)(Math.random()*3)+1);

        //如何接听客户未停机
        if (!isStopArrears){
            //定义并初始化接听通话信息
            TelephoneInformation answerTelInfo = new TelephoneInformation();

            //随机生成接听状态，1-未接听,2-接听
            byte answerState = (byte)((Math.random()*2)+1);
            System.out.println(answerState);
            //未接听-通话失败；接听-通话成功
            switch (answerState){
                case 1:
                    answerTelInfo.setIsCallSuccess(false);
                    dialTelInfo.setIsCallSuccess(false);
                    break;
                case 2:
                    answerTelInfo.setIsCallSuccess(true);
                    dialTelInfo.setIsCallSuccess(true);
                    break;
            }

            answerTelInfo.setCallBeginTime(callBeginTime);
            answerTelInfo.setDialCustomer(dialCustomer);
            answerTelInfo.setAnswerCustomer(answerCustomer);
            answerTelInfo.setConversationTime(0l);
            answerTelInfo.setCallConsumption(0d);
            answerTelInfo.setCallType(callType);
            answerTelInfo.setDialType(false);

            //添加成功后返回接听通话信息ID
            long answerTelInfoId = telephoneInformationService.saveTelInfo(answerTelInfo);

            //如果返回结果小于等于0表示添加失败，退出
            if (answerTelInfoId <= 0){
                resultMap.put("result", "-1");
                return resultMap;
            }

            //如果通话成功，则将answerTelInfo放入session中
            if (answerTelInfo.getIsCallSuccess()){
                //将接听通话信息放进session
                session.setAttribute("answerTelInfo", answerTelInfo);
            }

            //设置通话状态
            answerKind = answerState;
        }else{
            //当接听客户已停机时，设置通话状态为3
            answerKind = 3;
            dialTelInfo.setIsCallSuccess(false);
        }

        dialTelInfo.setDialCustomer(dialCustomer);
        dialTelInfo.setAnswerCustomer(answerCustomer);
        dialTelInfo.setCallType(callType);
        dialTelInfo.setCallBeginTime(callBeginTime);
        dialTelInfo.setCallConsumption(0d);
        dialTelInfo.setConversationTime(0l);
        dialTelInfo.setDialType(true);

        long dialTelInfoId = telephoneInformationService.saveTelInfo(dialTelInfo);
        //如果返回结果小于等于0表示添加失败，退出
        if (dialTelInfoId <= 0){
            resultMap.put("result", "-1");
            return resultMap;
        }
        session.setAttribute("dialTelInfo", dialTelInfo);

        //如果通话成功，则将answerTelInfo放入session中
        if (dialTelInfo.getIsCallSuccess()){
            //设置接听通话信息ID
            dialTelInfo.setId(dialTelInfoId);
            //将接听通话信息放进session
            session.setAttribute("dialTelInfo", dialTelInfo);
        }

        //返回通话状态
        resultMap.put("result", answerKind);
        return resultMap;
    }

    @RequestMapping(value = "updateTelInfo.do")
    @ResponseBody
    public Map updateTelInfo(@RequestBody TelInfoVo telInfoVo, HttpServletRequest request){
        //定义结果集
        Map<String,Object> resultMap = new HashMap<>();

        if (telInfoVo.getPhoneCode() == null || telInfoVo.getPhoneCode() == ""){
            resultMap.put("result", "0");
            return resultMap;
        }
        Map<String,Object> dialMap = new HashMap<>();
        dialMap.put("phoneCode", telInfoVo.getPhoneCode());
        Customer dialCustomer = customerService.getCustomer(dialMap);
        //如果session中客户不存在，表示session有效期已过，提醒用户重新登录
        if (dialCustomer == null){
            resultMap.put("result", "通话结束");
            return resultMap;
        }

        HttpSession session = request.getSession();
        //从session中获得拨打通话记录
        TelephoneInformation dialTelInfo = (TelephoneInformation) session.getAttribute("dialTelInfo");
        //从session中获得接听通话记录
        TelephoneInformation answerTelInfo = (TelephoneInformation) session.getAttribute("answerTelInfo");

        //获得结束时间
        Date callEndTime = new Date();
        //获得通话时长
        System.out.println(callEndTime.getTime());
        System.out.println(dialTelInfo.getCallBeginTime().getTime());
        long conversationTime = callEndTime.getTime() - dialTelInfo.getCallBeginTime().getTime();
        //定义通话费用并初始化
        double callConsumption = 0d;
        //根据通话类型获得通话费用
        switch (dialTelInfo.getCallType()){
            case 1: callConsumption = ((conversationTime-conversationTime%60)/60000+1)*0.15;
                break;
            case 2: callConsumption = ((conversationTime-conversationTime%60)/60000+1)*0.3;
                break;
            case 3: callConsumption = ((conversationTime-conversationTime%60)/60000+1)*0.5;
                break;
            default: break;
        }
        //从用户余额中扣除电话费
        dialCustomer.setBalance(dialCustomer.getBalance().doubleValue() - callConsumption);
        //设置电话费
        dialTelInfo.setCallConsumption(callConsumption);

        dialTelInfo.setCallEndTime(callEndTime);
        dialTelInfo.setConversationTime(conversationTime);

        answerTelInfo.setCallEndTime(callEndTime);
        answerTelInfo.setConversationTime(conversationTime);
        //更新拨打通话记录信息
        telephoneInformationService.updateTelInfo(dialTelInfo);
        //更新接听通话记录信息
        telephoneInformationService.updateTelInfo(answerTelInfo);
        //更新当前客户信息
        customerService.updateCustomer(dialCustomer);
        //移除session中接听信息记录answerTelInfo
        session.removeAttribute("answerTelInfo");
        //移除session中拨打信息记录dialTelInfo
        session.removeAttribute("dialTelInfo");
        resultMap.put("result", "通话结束");
        return resultMap;
    }

    @RequestMapping(value = "findTelInfoList.do")
    @ResponseBody
    public Map findTelInfoList(@RequestBody TelInfoVo telInfoVo){
        //定义结果集
        Map<String,Object> resultMap = new HashMap<>();
        if (telInfoVo.getPhoneCode() == null || telInfoVo.getPhoneCode() == ""){
            resultMap.put("result", "0");
            return resultMap;
        }
        Map<String,Object> customerMap = new HashMap<>();
        customerMap.put("phoneCode", telInfoVo.getPhoneCode());
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
        List<TelephoneInformation> telInfoList = telephoneInformationService.findTelInfoList(pageMap);

        resultMap.put("result", "1");
        resultMap.put("telInfoList", telInfoList);

        return resultMap;
    }

    @RequestMapping(value = "deleteTelInfo.do")
    @ResponseBody
    public Map deleteTelInfo(@RequestBody TelInfoVo telInfoVo){
        //定义结果集
        Map<String,Object> resultMap = new HashMap<>();
        if (telInfoVo.getPhoneCode() == null || telInfoVo.getPhoneCode() == ""){
            resultMap.put("result", "请登录");
            return resultMap;
        }
        Map<String,Object> customerMap = new HashMap<>();
        customerMap.put("phoneCode", telInfoVo.getPhoneCode());
        Customer customer = customerService.getCustomer(customerMap);
        //如果session中客户不存在，表示session有效期已过，提醒用户重新登录
        if (customer == null){
            resultMap.put("result", "请登录");
            return resultMap;
        }

        if (telephoneInformationService.deleteTelInfo(telInfoVo.getTelInfoId()) > 0){
            resultMap.put("result", "删除成功");
        }else {
            resultMap.put("result", "删除失败");
        }

        return resultMap;
    }
}

