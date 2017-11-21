package com.xwsxjt.service; /**
 * @Project: task-web
 * @Package com.xwsxjt.service
 * @author xiaoshijie
 * @date 2017/10/30 19:26
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.xwsxjt.domain.Customer;
import com.xwsxjt.domain.TelephoneInformation;

import java.util.List;
import java.util.Map;

/**
 * @author xiaoshijie
 * @InterfaceName TelephoneInformationService
 * @Description 通话信息Service接口类
 * @date 2017/10/30
 */
public interface TelephoneInformationService {
    /**
     * @Title: saveTelInfo
     * @Description: 添加通话记录
     * @author xiaoshijie
     * @date 2017-10-31
     * @param telephoneInformation
     * @return long
     */
    public long saveTelInfo(TelephoneInformation telephoneInformation);
    /**
     * @Title: updateTelInfo
     * @Description: 更新通话记录
     * @author xiaoshijie
     * @date 2017-10-31
     * @param telephoneInformation
     * @return int
     */
    public int updateTelInfo(TelephoneInformation telephoneInformation);
    /**
     * @Title: deleteTelInfo
     * @Description: 删除通话记录
     * @author xiaoshijie
     * @date 2017-10-31
     * @param id
     * @return int
     */
    public int deleteTelInfo(long id);
    /**
     * @Title: findTelInfoList
     * @Description: 通过客户ID和分页信息获得通话记录
     * @author xiaoshijie
     * @date 2017-10-31
     * @param pageMap
     * @return List
     */
    public List<TelephoneInformation> findTelInfoList(Map pageMap);
}
