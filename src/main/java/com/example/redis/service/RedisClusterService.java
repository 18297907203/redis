package com.example.redis.service;

import java.util.Map;

/**
 * @创建人 Jay
 * @创建时间 2019/12/26
 * @描述 测试Redis集群Service
 */
public interface RedisClusterService {
    Object getValue(String key);
    String setInfo(String key,String value,int expSecond);

    //    redis测试
    Map<String,Object> redisClusterTest();
}
