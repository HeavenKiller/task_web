package com.xwsxjt.service; /**
 * @Project: task-web
 * @Package com.xwsxjt.service
 * @author xiaoshijie
 * @date 2017/10/25 10:01
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.xwsxjt.base.domain.Page;
import com.xwsxjt.dao.PackageInformationDao;
import com.xwsxjt.domain.PackageInformation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author xiaoshijie
 * @ClassName PackageInformationServiceImpl
 * @Description 类描述
 * @date 2017/10/25
 */
@Service(value = "packageInformationService")
public class PackageInformationServiceImpl implements PackageInformationService {
    @Resource
    private PackageInformationDao packageInformationDao;
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
        //检查或初始化page
        Page.checkOrInitPage(page);
        page.setPageNowCounts(Page.getPageNowCountsByPageNowAndPageSize(page.getPageNow(),page.getPageSize()));
        return packageInformationDao.getPackageInformationList(page);
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
        return packageInformationDao.getRowCount();
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
        return packageInformationDao.getPackInfo(packInfoMap);
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
        return packageInformationDao.getPackInfoAllInfo(packInfoMap);
    }
}

