package com.example.demo.mapper;

import com.example.demo.Pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UsersMapper {
    @Select("select * from yyz")
    List<User> findUsers();

    @Insert("insert into yyz (username, password) values (#{username},#{password})")
    void addUsers(@Param("username") String username, @Param("password") String password);

    @Select("select username, score from yyz where username=#{username}")
    User getByUsername(String username);
}
