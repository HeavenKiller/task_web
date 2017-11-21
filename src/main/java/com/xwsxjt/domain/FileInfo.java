package com.xwsxjt.domain; /**
 * @Project: zyht_web
 * @Package com.domain
 * @author xiaoshijie
 * @date 2017/10/10 9:21
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import com.fasterxml.jackson.annotation.JsonFormat;
import com.xwsxjt.base.domain.IdEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author xiaoshijie
 * @ClassName FileInfo
 * @Description 文件信息类
 * @date 2017/10/10
 */
public class FileInfo extends IdEntity<Long> {
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 文件路径
     */
    private String filePath;
    /**
     * 文件类型
     */
    private String fileType;
    /**
     * 文件大小
     */
    private Long fileSize;
    /**
     * 创建时间
     */
    @DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "id='" + getId() + '\'' +
                ",fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileType='" + fileType + '\'' +
                ", fileSize=" + fileSize +
                ", createTime=" + createTime +
                '}';
    }
}

