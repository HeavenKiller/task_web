package com.xwsxjt.dao; /**
 * @Project: task-web
 * @Package com.xwsxjt.dao
 * @author xiaoshijie
 * @date 2017/10/26 22:50
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.xwsxjt.base.dao.BaseDaoImpl;
import com.xwsxjt.domain.FileInfo;
import org.springframework.stereotype.Repository;

/**
 * @author xiaoshijie
 * @ClassName FileInfoDaoImpl
 * @Description 文件信息Dao实现类
 * @date 2017/10/26
 */
@Repository(value = "fileInfoDao")
public class FileInfoDaoImpl extends BaseDaoImpl<FileInfo> implements FileInfoDao {
    /**
     * @Title: findFileInfoById
     * @Description: 通过ID获得文件信息
     * @author xiaoshijie
     * @date 2017-10-10
     */
    @Override
    public FileInfo findFileInfoById(long id) {
        return sqlSessionTemplate.selectOne(getMybaitsNameSpace()+"getFileInfo", id);
    }
}

