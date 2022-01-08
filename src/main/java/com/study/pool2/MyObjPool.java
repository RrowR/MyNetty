package com.study.pool2;

import com.study.bean.User;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * atlan 2022/1/8 23:59
 */
public class MyObjPool {
    public static void main(String[] args) throws Exception {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        UserFactory userFactory = new UserFactory();
        GenericObjectPool<User> userGenericObjectPool = new GenericObjectPool<User>(userFactory,config);
        User user = userGenericObjectPool.borrowObject();
        System.out.println(user);

    }
}
