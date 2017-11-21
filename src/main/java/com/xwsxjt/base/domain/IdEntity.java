package com.xwsxjt.base.domain; /**
 * @Project: zyht_web
 * @Package com.domain
 * @author xiaoshijie
 * @date 2017/8/21 15:38
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author xiaoshijie
 * @ClassName IdEntity
 * @Description 公有属性类
 * @date 2017/8/21
 */
public class IdEntity<T> {
    /**
     * id--公有ID
     */
    protected T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}

