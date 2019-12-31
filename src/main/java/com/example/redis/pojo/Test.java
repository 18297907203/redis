package com.example.redis.pojo;

import org.springframework.stereotype.Component;

/**
 * @param
 * @创建人 Jay
 * @创建时间 2019/12/28
 * @描述
 */
@Component
public class Test {
    int id;
    int num;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "test{" +
                "id=" + id +
                ", num=" + num +
                '}';
    }
}
