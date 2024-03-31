package com.example.demo.Controller;

import com.example.demo.Pojo.Result;
import com.example.demo.Pojo.ScoreDTO;
import com.example.demo.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    UsersService usersService;
    @PostMapping("/add")
    public Result addScore(@RequestBody ScoreDTO scoreDTO, HttpServletRequest request){
        String username = (String) request.getAttribute("username");
        usersService.ifAuth(username);
        usersService.addScore(scoreDTO);
        return Result.success();
    }
}
