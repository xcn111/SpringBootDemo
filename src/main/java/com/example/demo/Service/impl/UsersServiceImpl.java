package com.example.demo.Service.impl;

import com.example.demo.Pojo.ScoreDTO;
import com.example.demo.Pojo.User;
import com.example.demo.Pojo.UserDTO;
import com.example.demo.Service.UsersService;
import com.example.demo.mapper.ScoreMapper;
import com.example.demo.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.Objects;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private ScoreMapper scoreMapper;
    @Override
    public List<User> getAllUsers() {
        return usersMapper.findUsers();
    }

    @Override
    public void addUser(UserDTO userDTO) {
        String username=userDTO.getUsername();
        String password=MD5(userDTO.getPassword());
        int auth=userDTO.getAuth();
        usersMapper.addUsers(username, password, auth);
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
        return usersMapper.getByUsername(username);
    }

    @Override
    public void DeleteUser(UserDTO userDTO) {
        String username=userDTO.getUsername();
        User user=getUserByName(username);
        if(user==null) throw new RuntimeException("user not exist");
        usersMapper.DeleteUser(userDTO);
    }

    @Override
    public void ChangePassword(UserDTO userDTO) {
        String username=userDTO.getUsername();
        User user=getUserByName(username);
        if(user==null) throw new RuntimeException("user not exist");
        String password=MD5(userDTO.getPassword());
        System.out.println(password);
        usersMapper.ChangePassword(username, password);
    }

    @Override
    public void ifAuth(String username) {
        int auth= usersMapper.findAuth(username);
        if(auth!=1) throw new RuntimeException("have no authority");
    }

}
