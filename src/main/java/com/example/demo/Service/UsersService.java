package com.example.demo.Service;


import com.example.demo.Pojo.User;
import com.example.demo.Pojo.UserDTO;
import com.example.demo.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UsersService {
    List<User> getAllUsers();
    void addUser(String username, String password);

    String MD5(String password);

    User login(UserDTO userDTO);

    User getUserByName(String username);
}
