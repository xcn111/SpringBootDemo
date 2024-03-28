package com.example.demo.Service.impl;

import com.example.demo.Pojo.User;
import com.example.demo.Pojo.UserDTO;
import com.example.demo.Service.UsersService;
import com.example.demo.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.Objects;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;
    @Override
    public List<User> getAllUsers() {
        return usersMapper.findUsers();
    }

    @Override
    public void addUser(String username, String password) {
        usersMapper.addUsers(username, password);
    }

    @Override
    public String MD5(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }

    @Override
    public User login(UserDTO userDTO) {
        String username=userDTO.getUsername();
        String password=userDTO.getPassword();
        User user=usersMapper.getByUsername(username);
        if(Objects.equals(MD5(password), user.getPassword())) return user;
        else throw new RuntimeException("wrong password");
    }

    @Override
    public User getUserByName(String username) {
        System.out.println(username);
        return usersMapper.getByUsername(username);
    }


}
