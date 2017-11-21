package com.xwsxjt.dao; /**
 * @Project: task-web
 * @Package com.xwsxjt.dao
 * @author xiaoshijie
 * @date 2017/10/26 22:48
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.xwsxjt.domain.FileInfo;

/**
 * @author xiaoshijie
 * @InterfaceName FileInfoDao
 * @Description 文件信息Dao接口类
 * @date 2017/10/26
 */
public interface FileInfoDao {
    /**
     * @Title: findFileInfoById
     * @Description: 通过ID获得文件信息
     * @author xiaoshijie
     * @date 2017-10-10
     * @param id 文件信息ID
     * @return FileInfo
     */
    public FileInfo findFileInfoById(long id);
}
