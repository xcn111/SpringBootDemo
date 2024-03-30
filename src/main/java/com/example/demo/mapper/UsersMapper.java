package com.example.demo.mapper;

import com.example.demo.Pojo.User;
import com.example.demo.Pojo.UserDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UsersMapper {
    @Select("select * from yyz")
    List<User> findUsers();

    @Insert("insert into yyz (username, password) values (#{username},#{password})")
    void addUsers(@Param("username") String username, @Param("password") String password);

    @Select("select * from yyz where username=#{username}")
    User getByUsername(String username);

    @Delete("delete from yyz where username=#{username}")
    void DeleteUser(UserDTO userDTO);

    @Update("update yyz set password=#{password} where username=#{username}")
    void ChangePassword(@Param("username") String username, @Param("password") String password);
}
