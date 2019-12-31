package com.example.redis.mapper;

import com.example.redis.pojo.Test;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @创建人 Jay
 * @创建时间 2019/12/26
 * @描述 RedisCluster测试
 */
@Mapper
@Repository
public interface RedisClusterMapper {
    List<Test> redisClusterTest();

    int redisClusterTest2(Test test);
}
