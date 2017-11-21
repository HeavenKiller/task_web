package com.xwsxjt.dao; /**
 * @Project: task-web
 * @Package com.xwsxjt.dao
 * @author xiaoshijie
 * @date 2017/10/25 9:49
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.xwsxjt.base.dao.BaseDaoImpl;
import com.xwsxjt.base.domain.Page;
import com.xwsxjt.domain.PackageInformation;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author xiaoshijie
 * @ClassName PackageInformationDaoImpl
 * @Description 类描述
 * @date 2017/10/25
 */
@Repository(value = "packageInformationDao")
public class PackageInformationDaoImpl extends BaseDaoImpl<PackageInformation> implements PackageInformationDao {
    /**
     * @Title: getPackageInformationList
     * @Description: 根据分页信息获得套餐信息集合
     * @author xiaoshijie
     * @date 2017-10-25
     * @param page 分页信息
     * @return List
     */
    @Override
    public List<PackageInformation> getPackageInformationList(Page page) {
        return sqlSessionTemplate.selectList(getMybaitsNameSpace()+"getPackageInformationList", page);
    }

    /**
     * @Title: getRowCount
     * @Description: 获得数据总条数
     * @author xiaoshijie
     * @date 2017-10-26
     * @return int
     */
    @Override
    public int getRowCount() {
        return sqlSessionTemplate.selectOne(getMybaitsNameSpace()+"getRowCount");
    }

    /**
     * @Title: getPackInfo
     * @Description: 通过ID获得套餐信息
     * @author xiaoshijie
     * @date 2017-10-29
     * @param packInfoMap
     * @return PackageInformation
     */
    @Override
    public PackageInformation getPackInfo(Map packInfoMap) {
        return sqlSessionTemplate.selectOne(getMybaitsNameSpace()+"getPackInfo", packInfoMap);
    }
    /**
     * @Title: getPackInfoAllInfo
     * @Description: 通过ID获得套餐信息
     * @author xiaoshijie
     * @date 2017-10-29
     * @param packInfoMap
     * @return PackageInformation
     */
    @Override
    public PackageInformation getPackInfoAllInfo(Map packInfoMap) {
        return sqlSessionTemplate.selectOne(getMybaitsNameSpace()+"getPackInfoAllInfo", packInfoMap);
    }
}

