package com.xwsxjt.domain; /**
 * @Project: zyht_web
 * @Package com.domain
 * @author xiaoshijie
 * @date 2017/10/10 9:30
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.xwsxjt.base.domain.IdEntity;

/**
 * @author xiaoshijie
 * @ClassName PackInfoImage
 * @Description 套餐图片信息
 * @date 2017/10/10
 */
public class PackInfoImage extends IdEntity<Long>{
    /**
     * 套餐信息ID
     */
    private PackageInformation packageInformation;
    /**
     * 文件信息ID
     */
    private FileInfo fileInfo;

    public PackageInformation getPackageInformation() {
        return packageInformation;
    }

    public void setPackageInformation(PackageInformation packageInformation) {
        this.packageInformation = packageInformation;
    }

    public FileInfo getFileInfo() {
        return fileInfo;
    }

    public void setFileInfo(FileInfo fileInfo) {
        this.fileInfo = fileInfo;
    }

    @Override
    public String toString() {
        return "PackInfoImage{" +
                "id=" + getId() +
                ", packageInformation=" + packageInformation +
                ", fileInfo=" + fileInfo +
                '}';
    }
}

