package com.xwsxjt.controller; /**
 * @Project: task-web
 * @Package com.xwsxjt.controller
 * @author xiaoshijie
 * @date 2017/10/29 17:18
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.xwsxjt.base.domain.Page;
import com.xwsxjt.domain.Customer;
import com.xwsxjt.domain.PackPurInformation;
import com.xwsxjt.domain.PackageInformation;
import com.xwsxjt.service.CustomerService;
import com.xwsxjt.service.PackPurInformationService;
import com.xwsxjt.service.PackageInformationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.xwsxjt.vo.PackPurInfoVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author xiaoshijie
 * @ClassName packPurInformationController
 * @Description 套餐购买Controller类
 * @date 2017/10/29
 */
@Controller
@RequestMapping(value = "packpurinfo")
public class PackPurInformationController {
    @Resource
    private CustomerService customerService;
    @Resource
    private PackageInformationService packageInformationService;
    @Resource
    private PackPurInformationService packPurInformationService;

    @RequestMapping(value = "buyPackInfo.do", method = RequestMethod.POST)
    @ResponseBody
    public Map buyPackPurInfo(@RequestBody PackPurInfoVo packPurInfoVo, HttpServletRequest request){
        Customer customer = null;
        //定义结果集
        Map<String,Object> resultMap = new HashMap<>();

        if (packPurInfoVo.getPhoneCode() == null || packPurInfoVo.getPhoneCode() == ""){
            resultMap.put("result", "请登录");
            return resultMap;
        }

        Map<String, String> customerMap = new HashMap<>();
        customerMap.put("phoneCode", packPurInfoVo.getPhoneCode());

        customer = customerService.getCustomer(customerMap);
        if (customer == null){
            resultMap.put("result", "请登录");
            return resultMap;
        }

        Map<String, Object> packInfoMap = new HashMap<>();
        packInfoMap.put("id", packPurInfoVo.getPackInfoId());
        PackageInformation packageInformation = null;
        packageInformation = packageInformationService.getPackInfo(packInfoMap);
        //创建套餐购买记录对象并初始化
        PackPurInformation packPurInformation = new PackPurInformation();
        /**
         * 设置套餐购买记录属性值
         */
        packPurInformation.setPackageInformation(packageInformation);
        packPurInformation.setAmountOfPayment(packageInformation.getMonthlyRent());
        packPurInformation.setCustomer(customer);
        packPurInformation.setBuyTime(new Date());
        packPurInformation.setEffectTime(new Date());
        packPurInformation.setIsSuccess(true);

        if (packPurInformationService.savePackPurInfo(packPurInformation) > 0){
            customer.setPackageInformation(packageInformation);
            double balance = customer.getBalance().doubleValue() - packPurInformation.getAmountOfPayment().doubleValue();
            customer.setBalance(balance);
            customerService.updateCustomer(customer);
        }else {
            resultMap.put("result", "购买失败");
            return resultMap;
        }

        resultMap.put("result", "购买成功");
        return resultMap;
    }

    @RequestMapping(value = "findPackPurInfoList.do")
    @ResponseBody
    public Map findPackPurInfoListByPageAndCustomerId(@RequestBody PackPurInfoVo packPurInfoVo){
        Map<String, Object> customerMap = new HashMap<>();
        customerMap.put("phoneCode", packPurInfoVo.getPhoneCode());
        Customer customer = customerService.getCustomer(customerMap);

        Page page = new Page();
        page.setPageNow(packPurInfoVo.getPageNow());
        page.setPageSize(5);
        //检查pageSize和pageNow是否为空
        Page.checkOrInitPage(page);
        //为pageNowCounts设值
        page.setPageNowCounts(Page.getPageNowCountsByPageNowAndPageSize(page.getPageNow(),page.getPageSize()));
        //获得rowCount
        page.setRowCount(packPurInformationService.getRowCountForCustomer(customer.getId()));
        //获得pageCount
        page.setPageCount(Page.getPageCountByRowCountAndPageSize(page.getRowCount(),page.getPageSize()));


        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put("customerId", customer.getId());
        pageMap.put("pageNowCounts",page.getPageNowCounts());
        pageMap.put("pageSize", page.getPageSize());

        List<PackPurInformation> packPurInformationList = packPurInformationService.findPackPurInfoListByPageAndCustomerId(pageMap);

        Map<String, Object> map = new HashMap<>();
        map.put("page",page);
        map.put("packPurInformationList", packPurInformationList);
        return map;
    }

    @RequestMapping(value = "deletePackPurInfo.do")
    @ResponseBody
    public Map deletePackPurInfo(@RequestBody PackPurInfoVo packPurInfoVo){
        //定义结果集
        Map<String,Object> resultMap = new HashMap<>();

        if (packPurInfoVo.getPhoneCode() == null || packPurInfoVo.getPhoneCode() == ""){
            resultMap.put("result", "请登录");
            return resultMap;
        }

        Map<String,Object> customerMap = new HashMap<>();
        customerMap.put("phoneCode", packPurInfoVo.getPhoneCode());
        Customer customer = customerService.getCustomer(customerMap);
        if (customer == null){
            resultMap.put("result", "0");
            return resultMap;
        }

        Map<String,Object> packPurInfoMap = new HashMap<>();

        packPurInfoMap.put("id", packPurInfoVo.getPackPurInfoId());
        if (packPurInformationService.deletePackPurInfo(packPurInfoMap) > 0){
            Page page = new Page();
            page.setPageSize(5);
            //获得rowCount
            page.setRowCount(packPurInformationService.getRowCountForCustomer(customer.getId()));
            page.setPageNow(page.getRowCount()%page.getPageSize()==0?packPurInfoVo.getPageNow()-1:packPurInfoVo.getPageNow());

            //检查pageSize和pageNow是否为空
            Page.checkOrInitPage(page);
            //为pageNowCounts设值
            page.setPageNowCounts(Page.getPageNowCountsByPageNowAndPageSize(page.getPageNow(),page.getPageSize()));
            //获得pageCount
            page.setPageCount(Page.getPageCountByRowCountAndPageSize(page.getRowCount(),page.getPageSize()));


            Map<String, Object> pageMap = new HashMap<>();
            pageMap.put("customerId", customer.getId());
            pageMap.put("pageNowCounts",page.getPageNowCounts());
            pageMap.put("pageSize", page.getPageSize());

            List<PackPurInformation> packPurInformationList = packPurInformationService.findPackPurInfoListByPageAndCustomerId(pageMap);

            resultMap.put("page",page);
            resultMap.put("packPurInformationList", packPurInformationList);
            resultMap.put("result", "1");
        }else {
            resultMap.put("result", "-1");
        }
        return resultMap;
    }
}

