package com.example.demo;

import com.example.demo.Service.UsersService;
import com.example.demo.mapper.UsersMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.sql.DataSource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private DataSource dataSource;
    @Autowired
    UsersService usersService;

    @Autowired
    RedisTemplate redisTemplate;
    @Test
    void contextLoads(){
        ExecutorService executorService= Executors.newFixedThreadPool(200);
        for(int i=0;i<200;i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    usersService.getUserByName("ZhangSan");
                }
            });
        }
    }

    @Test
    void abab(){
        redisTemplate.opsForValue().set("sfewf","fdwqf");
    }

}
