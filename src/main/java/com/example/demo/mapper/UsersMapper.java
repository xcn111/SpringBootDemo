package com.example.demo.mapper;

import com.example.demo.Pojo.ScoreDTO;
import com.example.demo.Pojo.User;
import com.example.demo.Pojo.UserDTO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface UsersMapper {
    @Select("select * from user")
    List<User> findUsers();

    @Insert("insert into user (username, password, auth) values (#{username},#{password},#{auth})")
    void addUsers(@Param("username") String username, @Param("password") String password, @Param("auth") int auth);

    @Select("select * from user where username=#{username}")
    User getByUsername(String username);

    @Delete("delete from user where username=#{username}")
    void DeleteUser(UserDTO userDTO);

    @Update("update user set password=#{password} where username=#{username}")
    void ChangePassword(@Param("username") String username, @Param("password") String password);
    @Select("select auth from user where username=#{username}")
    int findAuth(@Param("username") String username);

    @Insert("insert into score (username, Math, Chinese, English) values (#{username}, #{math}, #{chinese}, #{english})")
    void addScore(ScoreDTO scoreDTO);
}
