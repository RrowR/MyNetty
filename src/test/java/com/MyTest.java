package com;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: atlan
 * @Date: 2022/1/5 11:17 下午
 */
public class MyTest {
    @Test
    public void Test01(){
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info("this is my {}","logger");
        logger.debug("this is my {}","logger");
        logger.warn("this is my {}","logger");
        logger.error("this is my {}","logger");
        logger.error("this is my {}","logger");

    }
}
