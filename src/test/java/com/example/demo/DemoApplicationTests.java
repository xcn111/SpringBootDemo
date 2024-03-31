package com.example.demo;

import com.example.demo.mapper.UsersMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private DataSource dataSource;
    @Test
    void contextLoads(){

    }

}
