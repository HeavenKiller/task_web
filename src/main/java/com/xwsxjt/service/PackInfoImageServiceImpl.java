package com.xwsxjt.service; /**
 * @Project: task-web
 * @Package com.xwsxjt.service
 * @author xiaoshijie
 * @date 2017/10/26 23:30
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.xwsxjt.dao.PackInfoImageDao;
import com.xwsxjt.domain.PackInfoImage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiaoshijie
 * @ClassName PackInfoImageServiceImpl
 * @Description 类描述
 * @date 2017/10/26
 */
@Service(value = "packInfoImageService")
public class PackInfoImageServiceImpl implements PackInfoImageService {
    @Resource
    private PackInfoImageDao packInfoImageDao;
    /**
     * @Title: findPackInfoImageListByPackInfoId
     * @Description: 根据套餐信息ID获得套餐图片信息集合
     * @author xiaoshijie
     * @date 2017-10-10
     * @param packInfoId 套餐信息ID
     * @return List
     */
    @Override
    public List<PackInfoImage> findPackInfoImageListByPackInfoId(long packInfoId) {
        return packInfoImageDao.findPackInfoImageListByPackInfoId(packInfoId);
    }
}

