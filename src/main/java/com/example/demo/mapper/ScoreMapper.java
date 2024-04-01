package com.example.demo.mapper;

import com.example.demo.Pojo.ScoreDTO;
import com.example.demo.Pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ScoreMapper {

    @Insert("insert into score (username, Math, Chinese, English) values (#{username}, #{math}, #{chinese}, #{english})")
    void addScore(ScoreDTO scoreDTO);

    void addScoreList(List<ScoreDTO> scoreDTOS);

    @Select("select username, Math, Chinese, English from score")
    List<ScoreDTO> findScores();

    @Select("select username, Math, Chinese, English from score where username=#{username}")
    List<ScoreDTO> findScoreByName(@Param("username") String username);
}
