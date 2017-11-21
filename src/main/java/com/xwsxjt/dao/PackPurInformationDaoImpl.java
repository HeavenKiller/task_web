package com.xwsxjt.dao; /**
 * @Project: task-web
 * @Package com.xwsxjt.dao
 * @author xiaoshijie
 * @date 2017/10/29 16:08
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.xwsxjt.base.dao.BaseDaoImpl;
import com.xwsxjt.domain.PackPurInformation;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author xiaoshijie
 * @ClassName PackPurInfoDaoImpl
 * @Description 套餐购买Dao实现类
 * @date 2017/10/29
 */
@Repository("packPurInformationDao")
public class PackPurInformationDaoImpl extends BaseDaoImpl<PackPurInformation> implements PackPurInformationDao {
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
        sqlSessionTemplate.insert(getMybaitsNameSpace()+"savePackPurInfo", packPurInformation);
        return packPurInformation.getId();
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
        return sqlSessionTemplate.selectList(getMybaitsNameSpace() + "findPackPurInfoList", pageMap);
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
        return sqlSessionTemplate.delete(getMybaitsNameSpace()+"deletePackPurInfo", packPurInfoMap);
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
        return sqlSessionTemplate.selectOne(getMybaitsNameSpace()+"getRowCountForCustomer",customerId);
    }
}

