package com.test2;

import com.study.bean.User;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.junit.Test;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * atlan 2022/1/8 0:41
 */
public class TestMain {
    @Test
    public void Test01(){
        LinkedBlockingDeque<String> deque = new LinkedBlockingDeque<>(20000);

    }

    @Test
    public void Test02(){
        // GenericObjectPool<User> objectPool = new GenericObjectPool<User>();

    }
}
