package com.example.redis.controller;

import com.example.redis.service.RedisClusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @创建人 Jay
 * @创建时间 2019/12/26
 * @描述 测试redis集群
 */
@Controller
@RequestMapping("redisCluster")
public class RedisClusterController {

    @Autowired
    RedisClusterService redisClusterService;

    /**
     * 根据键获取redis中对应的值
     * @param key
     * @return
     */
    @ResponseBody
    @RequestMapping("/get")
    public Object getValue(String key){
        Object value = redisClusterService.getValue(key);
        return value;
    }

    /**
     * 向redis集群中存入值
     * @param key
     * @param value
     * @return
     */
    @ResponseBody
    @RequestMapping("/set")
    public String setInfo(String key,String value,int expSecond){
        try {
            String set =  redisClusterService.setInfo(key,value,expSecond);
            return "已存入缓存。。。"+set;
        } catch (Exception e) {
            e.printStackTrace();
            return "缓存存入失败。。。";
        }
    }

    //    redis集群测试
    @ResponseBody
    @RequestMapping("/test")
    public Map<String,Object> redisClusterTest(){
        return redisClusterService.redisClusterTest();
    }

}
