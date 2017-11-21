package com.xwsxjt.dao; /**
 * @Project: task-web
 * @Package com.xwsxjt.dao
 * @author xiaoshijie
 * @date 2017/10/26 23:12
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.xwsxjt.base.dao.BaseDaoImpl;
import com.xwsxjt.domain.PackInfoImage;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiaoshijie
 * @ClassName PackInfoImageDaoImpl
 * @Description 类描述
 * @date 2017/10/26
 */
@Repository(value = "packInfoImageDao")
public class PackInfoImageDaoImpl extends BaseDaoImpl<PackInfoImage> implements PackInfoImageDao{
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
        return sqlSessionTemplate.selectList(getMybaitsNameSpace()+"getPackInfoImage", packInfoId);
    }
}

