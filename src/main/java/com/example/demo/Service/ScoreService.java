package com.example.demo.Service;

import com.example.demo.Controller.ScoreController;
import com.example.demo.Pojo.ScoreDTO;
import com.example.demo.Pojo.User;

import java.util.List;

public interface ScoreService {

    void addScore(ScoreDTO scoreDTO);

    void addScoreList(List<ScoreDTO> scoreDTOS);

    List<ScoreDTO> getAllScore();

    List<ScoreDTO> getScoreByUsername(String username);
}
