package com.xwsxjt.dao; /**
 * @Project: task-web
 * @Package com.xwsxjt.dao
 * @author xiaoshijie
 * @date 2017/10/25 9:45
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.xwsxjt.base.domain.Page;
import com.xwsxjt.domain.PackageInformation;

import java.util.List;
import java.util.Map;

/**
 * @author xiaoshijie
 * @InterfaceName PackageInformationDao
 * @Description 套餐信息Dao接口类
 * @date 2017/10/25
 */
public interface PackageInformationDao {
    /**
     * @Title: getPackageInformationList
     * @Description: 根据分页信息获得套餐信息集合
     * @author xiaoshijie
     * @date 2017-10-25
     * @param page 分页信息
     * @return List
     */
    public List<PackageInformation> getPackageInformationList(Page page);

    /**
     * @Title: getRowCount
     * @Description: 获得数据总条数
     * @author xiaoshijie
     * @date 2017-10-26
     * @return int
     */
    public int getRowCount();

    /**
     * @Title: getPackInfo
     * @Description: 通过ID获得套餐信息
     * @author xiaoshijie
     * @date 2017-10-29
     * @param packInfoMap
     * @return PackageInformation
     */
    public PackageInformation getPackInfo(Map packInfoMap);

    /**
     * @Title: getPackInfoAllInfo
     * @Description: 通过ID获得套餐信息
     * @author xiaoshijie
     * @date 2017-10-29
     * @param packInfoMap
     * @return PackageInformation
     */
    public PackageInformation getPackInfoAllInfo(Map packInfoMap);
}
