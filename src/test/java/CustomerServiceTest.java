/**
 * @Project: task-web
 * @Package PACKAGE_NAME
 * @author xiaoshijie
 * @date 2017/10/20 16:49
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.xwsxjt.domain.Customer;
import com.xwsxjt.service.CustomerService;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @author xiaoshijie
 * @ClassName CustomerServiceTest
 * @Description jedis测试
 * @date 2017/10/20
 */

public class CustomerServiceTest {
    private static Logger logger = LogManager.getLogger(CustomerServiceTest.class);
    @Test
    public void showTest(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.select(0);
        Set<String> keySet = jedis.keys("*");

        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()){
            String keyName = iterator.next();
            if ("string".equals(jedis.type(keyName))){
                logger.info(keyName+":"+jedis.get(keyName));
            }else if ("hash".equals(jedis.type(keyName))){
                Map<String, String> map = jedis.hgetAll(keyName);
                Set<Map.Entry<String,String>> entrySet = map.entrySet();
                for (Map.Entry<String,String> entry:entrySet){
                    logger.info(keyName+":"+entry.getKey()+":"+entry.getValue());
                }
//                for (String value:map.values()){}
            }else if ("list".equals(jedis.type(keyName))){
                List<String> objectList = jedis.lrange(keyName,0l,-1l);
                for (String obj:objectList){
                    logger.info(keyName+":"+obj+":"+jedis.get(obj));
                }
            }else if ("set".equals(jedis.type(keyName))){
                /**
                 * 使用sscan叠代集合中的元素
                 * ScanParams叠代参数，使用
                 */
                ScanParams scanParams = new ScanParams();
                scanParams.match("s*");
                ScanResult<String> result = jedis.sscan(keyName, "0", scanParams);
                for (String value:result.getResult()){
                    logger.info(keyName+":"+value);
                }
//                Set<String> stringSet = jedis.smembers(keyName);
//                for (String value:stringSet){
//                    logger.info(keyName+":"+value);
//                }
            }
        }
//        jedis.select(2);
    }




}

