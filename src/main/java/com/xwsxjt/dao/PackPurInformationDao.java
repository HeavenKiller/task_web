package com.xwsxjt.dao; /**
 * @Project: task-web
 * @Package com.xwsxjt.dao
 * @author xiaoshijie
 * @date 2017/10/29 16:08
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.xwsxjt.domain.PackPurInformation;

import java.util.List;
import java.util.Map;

/**
 * @author xiaoshijie
 * @InterfaceName PackPurInfoDao
 * @Description 套餐购买Dao接口类
 * @date 2017/10/29
 */
public interface PackPurInformationDao {
    /**
     * @Title: 添加套餐购买信息
     * @Description: savePackPurInfo
     * @author xiaoshijie
     * @date 2017-10-29
     * @param packPurInformation
     * @return long
     */
    public long savePackPurInfo(PackPurInformation packPurInformation);

    /**
     * @Title: findPackPurInfoListByPageAndCustomerId
     * @Description: 获得客户套餐购买记录
     * @author xiaoshijie
     * @date 2017-10-29
     * @param pageMap
     * @return List
     */
    public List<PackPurInformation> findPackPurInfoListByPageAndCustomerId(Map pageMap);

    /**
     * @Title: deletePackPurInfo
     * @Description: 根据ID删除套餐信息
     * @author xiaoshijie
     * @date 2017-10-30
     * @param packPurInfoMap
     * @return int
     */
    public int deletePackPurInfo(Map packPurInfoMap);

    /** 
     * @Title: getRowCountForCustomer
     * @Description: 获得客户的套餐购买记录
     * @author xiaoshijie
     * @date 2017-10-30
     * @param customerId
     * @return int
     */
    public int getRowCountForCustomer(long customerId);
}
