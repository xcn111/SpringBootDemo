package com.example.demo.Service.impl;

import com.example.demo.Pojo.ScoreDTO;
import com.example.demo.Pojo.User;
import com.example.demo.Service.ScoreService;
import com.example.demo.mapper.ScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    ScoreMapper scoreMapper;

    @Override
    public void addScore(ScoreDTO scoreDTO) {
        scoreMapper.addScore(scoreDTO);
    }

    @Override
    public void addScoreList(List<ScoreDTO> scoreDTOS) {
        scoreMapper.addScoreList(scoreDTOS);
    }

    @Override
    public List<ScoreDTO> getAllScore() {
        return scoreMapper.findScores();
    }

    @Override
    public List<ScoreDTO> getScoreByUsername(String username) {
        return scoreMapper.findScoreByName(username);
    }
}
