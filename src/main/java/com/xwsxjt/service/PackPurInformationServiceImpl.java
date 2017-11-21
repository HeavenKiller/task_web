package com.xwsxjt.service; /**
 * @Project: task-web
 * @Package com.xwsxjt.service
 * @author xiaoshijie
 * @date 2017/10/29 16:50
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.xwsxjt.dao.PackPurInformationDao;
import com.xwsxjt.domain.PackPurInformation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author xiaoshijie
 * @ClassName PackPurInformationServiceImpl
 * @Description 套餐购买Service实现类
 * @date 2017/10/29
 */
@Service("packPurInformationService")
public class PackPurInformationServiceImpl implements PackPurInformationService{
    @Resource
    private PackPurInformationDao packPurInformationDao;
    /**
     * @Title: 添加套餐购买信息
     * @Description: savePackPurInfo
     * @author xiaoshijie
     * @date 2017-10-29
     * @param packPurInformation
     * @return long
     */
    @Override
    public long savePackPurInfo(PackPurInformation packPurInformation) {
        return packPurInformationDao.savePackPurInfo(packPurInformation);
    }
    /**
     * @Title: findPackPurInfoListByPageAndCustomerId
     * @Description: 获得客户套餐购买记录
     * @author xiaoshijie
     * @date 2017-10-29
     * @param pageMap
     * @return List
     */
    @Override
    public List<PackPurInformation> findPackPurInfoListByPageAndCustomerId(Map pageMap) {
        return packPurInformationDao.findPackPurInfoListByPageAndCustomerId(pageMap);
    }
    /**
     * @Title: deletePackPurInfo
     * @Description: 根据ID删除套餐信息
     * @author xiaoshijie
     * @date 2017-10-30
     * @param packPurInfoMap
     * @return int
     */
    @Override
    public int deletePackPurInfo(Map packPurInfoMap) {
        return packPurInformationDao.deletePackPurInfo(packPurInfoMap);
    }
    /**
     * @Title: getRowCountForCustomer
     * @Description: 获得客户的套餐购买记录
     * @author xiaoshijie
     * @date 2017-10-30
     * @param customerId
     * @return int
     */
    @Override
    public int getRowCountForCustomer(long customerId) {
        return packPurInformationDao.getRowCountForCustomer(customerId);
    }
}

