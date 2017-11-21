package com.xwsxjt.service; /**
 * @Project: task-web
 * @Package com.xwsxjt.service
 * @author xiaoshijie
 * @date 2017/10/26 23:02
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.xwsxjt.dao.FileInfoDao;
import com.xwsxjt.domain.FileInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xiaoshijie
 * @ClassName FileInfoServiceImpl
 * @Description 类描述
 * @date 2017/10/26
 */
@Service(value = "fileInfoService")
public class FileInfoServiceImpl implements FileInfoService {
    @Resource
    private FileInfoDao fileInfoDao;
    /**
     * @Title: findFileInfoById
     * @Description: 通过ID获得文件信息
     * @author xiaoshijie
     * @date 2017-10-10
     * @param id 文件信息ID
     * @return FileInfo
     */
    @Override
    public FileInfo findFileInfoById(long id) {
        return fileInfoDao.findFileInfoById(id);
    }
}

