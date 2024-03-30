package com.example.demo.Controller;

import com.example.demo.Pojo.Result;
import com.example.demo.Pojo.User;
import com.example.demo.Pojo.UserDTO;
import com.example.demo.Service.UsersService;
import com.example.demo.util.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @GetMapping()
    public List<User> searchUser(){
        return usersService.getAllUsers();
    }

    @PostMapping("/register")
    public Result addUser(@RequestBody UserDTO userDTO){
        usersService.addUser(userDTO);
        return Result.success();
    }

    @PostMapping("/login")
    public Result login(@RequestBody UserDTO userDTO){
        User user=usersService.login(userDTO);
        String token=jwtTokenProvider.generateToken(user.getUsername());
        return Result.success("token",token);
    }

    @GetMapping("/currentUser")
    public Result GetCurrentUser(HttpServletRequest request){
        User user=usersService.getUserByName((String)request.getAttribute("username"));
        return Result.success("user", user);
    }

    @PostMapping("/delete")
    public Result DeleteUser(@RequestBody UserDTO userDTO){
        usersService.DeleteUser(userDTO);
        return Result.success();
    }

    @GetMapping("/{username}")
    public Result SearchUser(@PathVariable String username){
        User user=usersService.getUserByName(username);
        return Result.success("user", user);
    }

    @PostMapping("/change")
    public Result ChangePassword(@RequestBody UserDTO userDTO){
        usersService.ChangePassword(userDTO);
        return Result.success();
    }
}
