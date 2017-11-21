package com.xwsxjt.dao; /**
 * @Project: task-web
 * @Package com.xwsxjt.dao
 * @author xiaoshijie
 * @date 2017/10/31 19:23
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.xwsxjt.base.dao.BaseDaoImpl;
import com.xwsxjt.domain.Message;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author xiaoshijie
 * @ClassName MessageDaoImpl
 * @Description 类描述
 * @date 2017/10/31
 */
@Repository(value = "messageDao")
public class MessageDaoImpl extends BaseDaoImpl<Message> implements MessageDao {
    /**
     * @Title: saveMessage
     * @Description: 添加短信记录
     * @author xiaoshijie
     * @date 2017-10-31
     * @param message
     * @return long
     */
    @Override
    public long saveMessage(Message message) {
        sqlSessionTemplate.insert(getMybaitsNameSpace()+"saveMessage", message);
        return message.getId();
    }
    /**
     * @Title: deleteMessage
     * @Description: 删除短信记录
     * @author xiaoshijie
     * @date 2017-10-31
     * @param id
     * @return int
     */
    @Override
    public int deleteMessage(long id) {
        return sqlSessionTemplate.delete(getMybaitsNameSpace()+"deleteMessage", id);
    }
    /**
     * @Title: findMessageList
     * @Description: 通过当前客户和分页信息获得短信记录集合
     * @author xiaoshijie
     * @date 2017-10-31
     * @param pageMap
     * @return List
     */
    @Override
    public List<Message> findMessageList(Map pageMap) {
        return sqlSessionTemplate.selectList(getMybaitsNameSpace()+"findMessageList", pageMap);
    }
}

