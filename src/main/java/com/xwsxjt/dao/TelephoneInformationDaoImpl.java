package com.xwsxjt.dao; /**
 * @Project: task-web
 * @Package com.xwsxjt.dao
 * @author xiaoshijie
 * @date 2017/10/30 19:25
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.xwsxjt.base.dao.BaseDaoImpl;
import com.xwsxjt.domain.TelephoneInformation;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author xiaoshijie
 * @ClassName TelephoneInformationDaoImpl
 * @Description 通话信息Dao实现类
 * @date 2017/10/30
 */
@Repository(value = "telephoneInformationDao")
public class TelephoneInformationDaoImpl extends BaseDaoImpl<TelephoneInformation> implements TelephoneInformationDao {
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
        sqlSessionTemplate.insert(getMybaitsNameSpace()+"saveTelInfo",telephoneInformation);
        return telephoneInformation.getId();
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
        return sqlSessionTemplate.update(getMybaitsNameSpace()+"updateTelInfo",telephoneInformation);
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
        return sqlSessionTemplate.delete(getMybaitsNameSpace()+"deleteTelInfo", id);
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
        return sqlSessionTemplate.selectList(getMybaitsNameSpace()+"findTelInfoList",pageMap);
    }
}

