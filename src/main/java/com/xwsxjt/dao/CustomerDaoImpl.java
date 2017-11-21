package com.xwsxjt.dao; /**
 * @Project: task-web
 * @Package com.xwsxjt.dao
 * @author xiaoshijie
 * @date 2017/10/24 9:42
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.xwsxjt.base.dao.BaseDaoImpl;
import com.xwsxjt.domain.Customer;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author xiaoshijie
 * @ClassName CustomerDaoImpl
 * @Description 客户Dao实现类
 * @date 2017/10/24
 */
@Repository(value = "customerDao")
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao{
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
        return sqlSessionTemplate.selectOne(getMybaitsNameSpace()+"getCustomer",customerMap);
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
        return sqlSessionTemplate.selectOne(getMybaitsNameSpace()+"getCustomerAllInfo",customerMap);
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
        sqlSessionTemplate.insert(getMybaitsNameSpace()+"saveCustomer",customer);
        return customer.getId();
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
        sqlSessionTemplate.update(getMybaitsNameSpace()+"updateCustomer", customer);
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
        return sqlSessionTemplate.selectList(getMybaitsNameSpace()+"getCustomerList", phoneCode);
    }
}

