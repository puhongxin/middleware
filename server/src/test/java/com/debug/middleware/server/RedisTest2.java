package com.debug.middleware.server;
import com.debug.middleware.server.entity.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @description:
 * @author: xiaopu
 * @date: 2020-11-29 19:13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest2 {
    private static final Logger log= LoggerFactory.getLogger(RedisTest.class);
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    ObjectMapper objectMapper;
    @Test
    public void one() throws Exception{
        //构造用户个人实体对象
        Person p=new Person(10013,23,"修罗","debug","火星");

        //定义key与即将存入缓存中的value
        final String key="redis:test:1";
        String value=objectMapper.writeValueAsString(p);

        //写入缓存中
        log.info("存入缓存中的用户实体对象信息为：{} ",p);
        redisTemplate.opsForValue().set(key,value);

        //从缓存中获取用户实体信息
        Object res=redisTemplate.opsForValue().get(key);
        if (res!=null){
            Person resP=objectMapper.readValue(res.toString(),Person.class);
            log.info("从缓存中读取信息：{} ",resP);
        }
    }
}
