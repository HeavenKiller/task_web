package com.xwsxjt.service; /**
 * @Project: task-web
 * @Package com.xwsxjt.service
 * @author xiaoshijie
 * @date 2017/10/31 19:25
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.xwsxjt.dao.MessageDao;
import com.xwsxjt.domain.Message;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author xiaoshijie
 * @ClassName MessageServiceImpl
 * @Description 类描述
 * @date 2017/10/31
 */
@Repository(value = "messageService")
public class MessageServiceImpl implements MessageService {
    @Resource
    private MessageDao messageDao;
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
        return messageDao.saveMessage(message);
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
        return messageDao.deleteMessage(id);
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
        return messageDao.findMessageList(pageMap);
    }
}

