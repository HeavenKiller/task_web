package com.xwsxjt.controller; /**
 * @Project: task-web
 * @Package com.xwsxjt.controller
 * @author xiaoshijie
 * @date 2017/10/20 16:54
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.xwsxjt.domain.Customer;
import com.xwsxjt.service.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author xiaoshijie
 * @ClassName CustomerController
 * @Description 客户Controller类
 * @date 2017/10/20
 */
@Controller
@RequestMapping(value = "customer")
public class CustomerController {
    @Resource
    private CustomerService customerService;

    private static Logger logger = LogManager.getLogger(CustomerController.class.getName());

    @RequestMapping(value = "index.do")
    public ModelAndView index(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("index");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies){
            if ("customer".equals(cookie.getName())){
                logger.info(cookie.getValue());
            }
        }

        return modelAndView;
    }

    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody
    public Customer login(@RequestBody Customer customer){
        Map<String, Object> map = new HashMap<>();
        map.put("phoneCode", customer.getPhoneCode());
        Customer loginCustomer = customerService.getCustomer(map);
        logger.info(loginCustomer);
        return loginCustomer;
    }

    @RequestMapping(value = "getCustomerAllInfo.do", method = RequestMethod.POST)
    @ResponseBody
    public Customer getCustomerAllInfo(@RequestBody Customer customer){
        Map<String, Object> map = new HashMap<>();
        map.put("phoneCode", customer.getPhoneCode());
        Customer customerAllInfo = customerService.getCustomerAllInfo(map);
        logger.info(customerAllInfo);
        return customerAllInfo;
    }

    @RequestMapping(value = "getCustomerList.do")
    @ResponseBody
    public List<Customer> getCustomerList(@RequestBody Customer customer){
        if (customer == null && customer.getPhoneCode() == null && customer.getPhoneCode() == ""){
            return null;
        }
        return customerService.getCustomerList(customer.getPhoneCode());
    }
}

