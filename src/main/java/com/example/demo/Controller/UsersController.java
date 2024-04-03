package com.example.demo.Controller;

import com.example.demo.Pojo.Result;
import com.example.demo.Pojo.User;
import com.example.demo.Pojo.UserDTO;
import com.example.demo.Service.UsersService;
import com.example.demo.annotation.Authority;
import com.example.demo.annotation.CurrentUser;
import com.example.demo.util.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    RedisTemplate redisTemplate;
    @GetMapping()
    @Authority
    public List<User> searchUser(@CurrentUser User user){
        System.out.println(user);
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

//    @GetMapping("/currentUser")
//    public Result GetCurrentUser(HttpServletRequest request){
//        User user=usersService.getUserByName((String)request.getAttribute("username"));
//        return Result.success("user", user);
//    }

    @PostMapping("/delete")
    @Authority
    public Result DeleteUser(@CurrentUser User user, @RequestBody UserDTO userDTO){
        usersService.DeleteUser(userDTO);
        return Result.success();
    }

    @PostMapping("/change")
    public Result ChangePassword(@RequestBody UserDTO userDTO, HttpServletRequest request){
        String username=(String)request.getAttribute("username");
        if(!username.equals(userDTO.getUsername())) throw new RuntimeException("can not change the password");
        usersService.ChangePassword(userDTO);
        return Result.success();
    }

    @GetMapping("/test")
    public UserDTO Test(){
        return null;
    }
}
