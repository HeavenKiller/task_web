package com.xwsxjt.service; /**
 * @Project: task-web
 * @Package com.xwsxjt.service
 * @author xiaoshijie
 * @date 2017/10/30 19:27
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.xwsxjt.dao.CustomerDao;
import com.xwsxjt.dao.TelephoneInformationDao;
import com.xwsxjt.domain.Customer;
import com.xwsxjt.domain.TelephoneInformation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author xiaoshijie
 * @ClassName TelephoneInformationServiceImpl
 * @Description 通话信息Service实现类
 * @date 2017/10/30
 */
@Service(value = "telephoneInformationService")
public class TelephoneInformationServiceImpl implements TelephoneInformationService {
    @Resource
    private TelephoneInformationDao telephoneInformationDao;
    /**
     * @Title: saveTelInfo
     * @Description: 添加通话记录
     * @author xiaoshijie
     * @date 2017-10-31
     * @param telephoneInformation
     * @return long
     */
    @Override
    public long saveTelInfo(TelephoneInformation telephoneInformation) {
        return telephoneInformationDao.saveTelInfo(telephoneInformation);
    }
    /**
     * @Title: updateTelInfo
     * @Description: 更新通话记录
     * @author xiaoshijie
     * @date 2017-10-31
     * @param telephoneInformation
     * @return int
     */
    @Override
    public int updateTelInfo(TelephoneInformation telephoneInformation) {
        return telephoneInformationDao.updateTelInfo(telephoneInformation);
    }
    /**
     * @Title: deleteTelInfo
     * @Description: 删除通话记录
     * @author xiaoshijie
     * @date 2017-10-31
     * @param id
     * @return int
     */
    @Override
    public int deleteTelInfo(long id) {
        return telephoneInformationDao.deleteTelInfo(id);
    }
    /**
     * @Title: findTelInfoList
     * @Description: 通过客户ID和分页信息获得通话记录
     * @author xiaoshijie
     * @date 2017-10-31
     * @param pageMap
     * @return List
     */
    @Override
    public List<TelephoneInformation> findTelInfoList(Map pageMap) {
        return telephoneInformationDao.findTelInfoList(pageMap);
    }
}

