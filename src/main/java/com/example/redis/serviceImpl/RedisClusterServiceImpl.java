package com.example.redis.serviceImpl;

import com.example.redis.mapper.RedisClusterMapper;
import com.example.redis.pojo.Test;
import com.example.redis.service.RedisClusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    RedisClusterMapper redisClusterMapper;
    @Autowired
    Test test;

    @Override
    public Object getValue(String key) {
        return jedisCluster.get(key);
    }

    @Override
    public String setInfo(String key, String value,int expSecond) {
        String set = jedisCluster.set(key, value);
//        jedisCluster.expire(key,expSecond);
        return set;
    }

    //    redis集群测试
    @Override
    public Map<String, Object> redisClusterTest() {
        Map map = new HashMap();

        try {
            List list = redisClusterMapper.redisClusterTest();
            String key = "test";
            String value;
            int j;
            int k;
            jedisCluster.del(key);
            for (int i = 0;i < list.size();i++){
                String st = list.get(i).toString();
                value = st.substring(st.indexOf("num")+4,st.length()-1);
                j = Integer.parseInt(value);
                while ( j> 0){
                    Thread.sleep(1000);
                    j--;
                    value = j+"";
                    jedisCluster.set("test",value);
                    test.setNum(j);
                    System.out.println(jedisCluster.get(key)+"***********"+test.getNum());
                }
                test.setId(1);
                k = redisClusterMapper.redisClusterTest2(test);
                map.put("k",k);
            }
            map.put("result",list);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
