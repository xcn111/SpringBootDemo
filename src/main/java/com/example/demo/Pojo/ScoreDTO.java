package com.example.demo.Pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ScoreDTO implements Serializable {
    private String username;
    private String math;
    private int chinese;
    private int english;
}
