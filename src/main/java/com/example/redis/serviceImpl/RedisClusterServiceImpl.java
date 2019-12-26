package com.example.redis.serviceImpl;

import com.example.redis.service.RedisClusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

/**
 * @创建人 Jay
 * @创建时间 2019/12/26
 * @描述 测试Redis集群
 */
@Service
public class RedisClusterServiceImpl implements RedisClusterService {

    //注入JedisCluster
    @Autowired
    JedisCluster jedisCluster;


    @Override
    public Object getValue(String key) {
        return jedisCluster.get(key);
    }

    @Override
    public String setInfo(String key, String value) {
        String set = jedisCluster.set(key, value);
        return set;
    }
}
