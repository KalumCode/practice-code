package com.ggread.kalum.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@Slf4j
@RequestMapping(value = "/demo")
public class DemoController {

    @Autowired
    private RedisTemplate redisTemplate;

    private String REDIS_KEY = "Redis:Test";

    @GetMapping("/set")
    public Boolean set(String param) {
        leftPush(REDIS_KEY, param);
        return Boolean.TRUE;
    }

    @GetMapping("/get")
    public String get() {
        long listSize=listLength(REDIS_KEY);
        if(listSize<=0){
            return null;
        }
        return rightPop(REDIS_KEY).toString();
    }


    /**
     * 在变量左边添加元素值
     *
     * @param key
     * @param value
     * @return
     */
    public void leftPush(String key, Object value) {
        redisTemplate.opsForList().leftPush(key, value);
    }

    /**
     * 移除集合中的左边第一个元素。
     *
     * @param key
     * @return
     */
    public Object rightPop(String key) {
        return redisTemplate.opsForList().rightPop(key);
    }

    public long listLength(String key) {
        return redisTemplate.opsForList().size(key);
    }

}
