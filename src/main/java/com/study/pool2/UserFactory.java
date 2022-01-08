package com.study.pool2;

import com.study.bean.User;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.util.Date;

/**
 * atlan 2022/1/9 0:58
 */
public class UserFactory extends BasePooledObjectFactory<User> {
    @Override
    public User create() throws Exception {
        return new User("猫羽雫",16,new Date());
    }

    @Override
    public PooledObject<User> wrap(User obj) {
        return new DefaultPooledObject<>(obj);
    }

}
