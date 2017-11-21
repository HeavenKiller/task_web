package com.xwsxjt.dao; /**
 * @Project: task-web
 * @Package com.xwsxjt.dao
 * @author xiaoshijie
 * @date 2017/10/31 19:17
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.xwsxjt.domain.Message;

import java.util.List;
import java.util.Map;

/**
 * @author xiaoshijie
 * @InterfaceName MessageDao
 * @Description 短信Dao接口类
 * @date 2017/10/31
 */
public interface MessageDao {
    /**
     * @Title: saveMessage
     * @Description: 添加短信记录
     * @author xiaoshijie
     * @date 2017-10-31
     * @param message
     * @return long
     */
    public long saveMessage(Message message);
    /**
     * @Title: deleteMessage
     * @Description: 删除短信记录
     * @author xiaoshijie
     * @date 2017-10-31
     * @param id
     * @return int
     */
    public int deleteMessage(long id);
    /**
     * @Title: findMessageList
     * @Description: 通过当前客户和分页信息获得短信记录集合
     * @author xiaoshijie
     * @date 2017-10-31
     * @param pageMap
     * @return List
     */
    public List<Message> findMessageList(Map pageMap);
}
