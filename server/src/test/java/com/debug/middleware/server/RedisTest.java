package com.debug.middleware.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @description:
 * @author: xiaopu
 * @date: 2020-11-29 19:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {
    private static final Logger log= LoggerFactory.getLogger(RedisTest.class);
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    //将字符串写入缓存，并读取
    public void one(){
        log.info("------开始RedisTemplate操作组件实战----");

        //定义字符串内容以及存入缓存的key
        final String content="RedisTemplate实战字符串信息";
        final String key="redis:template:one:string";

        //Redis通用的操作组件
        ValueOperations valueOperations=redisTemplate.opsForValue();

        //将字符串信息写入缓存中
        log.info("写入缓存中的内容：{} ",content);
        valueOperations.set(key,content);

        //从缓存中读取内容
        Object result=valueOperations.get(key);
        log.info("读取出来的内容：{} ",result);
    }


}
