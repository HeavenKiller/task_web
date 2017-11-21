package com.xwsxjt.service; /**
 * @Project: task-web
 * @Package com.xwsxjt.service
 * @author xiaoshijie
 * @date 2017/10/26 23:29
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.xwsxjt.domain.PackInfoImage;

import java.util.List;

/**
 * @author xiaoshijie
 * @InterfaceName PackInfoImageService
 * @Description 套餐图片信息Service类
 * @date 2017/10/26
 */
public interface PackInfoImageService {
    /**
     * @Title: findPackInfoImageListByPackInfoId
     * @Description: 根据套餐信息ID获得套餐图片信息集合
     * @author xiaoshijie
     * @date 2017-10-10
     * @param packInfoId 套餐信息ID
     * @return List
     */
    public List<PackInfoImage> findPackInfoImageListByPackInfoId(long packInfoId);
}
