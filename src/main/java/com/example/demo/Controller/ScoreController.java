package com.example.demo.Controller;

import com.example.demo.Pojo.Result;
import com.example.demo.Pojo.ScoreDTO;
import com.example.demo.Pojo.User;
import com.example.demo.Service.ScoreService;
import com.example.demo.annotation.Authority;
import com.example.demo.annotation.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    ScoreService scoreService;
    @PostMapping("/add")
    @Authority
    @Transactional
    public Result addScore(@CurrentUser User user, @RequestBody ScoreDTO scoreDTO){
        scoreService.addScore(scoreDTO);
        return Result.success();
    }

    @PostMapping("/addlist")
    @Authority
    @Transactional
    public Result addScoreList(@CurrentUser User user, @RequestBody List<ScoreDTO> scoreDTO){
        scoreService.addScoreList(scoreDTO);
        return Result.success();
    }

    @GetMapping()
    public List<ScoreDTO> searchScore(@CurrentUser User user){
        int auth=user.getAuth();
        if(auth==1) return scoreService.getAllScore();
        else return scoreService.getScoreByUsername(user.getUsername());
    }
}
