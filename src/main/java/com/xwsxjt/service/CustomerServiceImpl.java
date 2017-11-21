package com.xwsxjt.service; /**
 * @Project: task-web
 * @Package com.xwsxjt.service
 * @author xiaoshijie
 * @date 2017/10/20 16:40
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.xwsxjt.dao.CustomerDao;
import com.xwsxjt.domain.Customer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author xiaoshijie
 * @ClassName CustomerServiceImpl
 * @Description 客户Service实现类
 * @date 2017/10/20
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerDao customerDao;
    /**
     * @Title: getCustomer
     * @Description: 根据客户id或者phoneCode查询客户信息
     * @author xiaoshijie
     * @date 2017-10-24
     * @param customerMap 客户id或phoneCode
     * @return Customer
     */
    @Override
    public Customer getCustomer(Map customerMap) {
        return customerDao.getCustomer(customerMap);
    }
    /**
     * @Title: getCustomerAllInfo
     * @Description: 根据客户id或者phoneCode查询客户suoyou信息
     * @author xiaoshijie
     * @date 2017-10-24
     * @param customerMap 客户id或phoneCode
     * @return Customer
     */
    @Override
    public Customer getCustomerAllInfo(Map customerMap) {
        return customerDao.getCustomerAllInfo(customerMap);
    }

    /**
     * @Title: saveCustomer
     * @Description: 添加客户信息
     * @author xiaoshijie
     * @date 2017-10-25
     * @param customer 客户信息
     * @return long
     */
    @Override
    public long saveCustomer(Customer customer) {
        return customerDao.saveCustomer(customer);
    }
    /**
     * @Title: updateCustomer
     * @Description: 更新客户信息
     * @author xiaoshijie
     * @date 2017-10-29
     * @param customer
     */
    @Override
    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }
    /**
     * @Title: getCustomerList
     * @Description: 获得客户集合
     * @author xiaoshijie
     * @date 2017-10-31
     * @param phoneCode
     * @return List
     */
    @Override
    public List<Customer> getCustomerList(String phoneCode) {
        return customerDao.getCustomerList(phoneCode);
    }
}

