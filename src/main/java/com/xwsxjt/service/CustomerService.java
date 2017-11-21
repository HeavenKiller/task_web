package com.xwsxjt.service; /**
 * @Project: task-web
 * @Package com.xwsxjt.service
 * @author xiaoshijie
 * @date 2017/10/20 16:38
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.xwsxjt.domain.Customer;

import java.util.List;
import java.util.Map;

/**
 * @author xiaoshijie
 * @InterfaceName CustomerService
 * @Description 客户信息Service接口
 * @date 2017/10/20
 */
public interface CustomerService {
    /**
     * @Title: getCustomer
     * @Description: 根据客户id或者phoneCode查询客户信息
     * @author xiaoshijie
     * @date 2017-10-24
     * @param customerMap 客户id或phoneCode
     * @return Customer
     */
    public Customer getCustomer(Map customerMap);
    /**
     * @Title: getCustomerAllInfo
     * @Description: 根据客户id或者phoneCode查询客户suoyou信息
     * @author xiaoshijie
     * @date 2017-10-24
     * @param customerMap 客户id或phoneCode
     * @return Customer
     */
    public Customer getCustomerAllInfo(Map customerMap);
    /**
     * @Title: saveCustomer
     * @Description: 添加客户信息
     * @author xiaoshijie
     * @date 2017-10-25
     * @param customer 客户信息
     * @return long
     */
    public long saveCustomer(Customer customer);
    /**
     * @Title: updateCustomer
     * @Description: 更新客户信息
     * @author xiaoshijie
     * @date 2017-10-29
     * @param customer
     */
    public void updateCustomer(Customer customer);
    /**
     * @Title: getCustomerList
     * @Description: 获得客户集合
     * @author xiaoshijie
     * @date 2017-10-31
     * @param phoneCode
     * @return List
     */
    public List<Customer> getCustomerList(String phoneCode);
}
