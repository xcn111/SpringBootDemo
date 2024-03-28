package com.example.demo.Pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class Result implements Serializable {
    private int code;
    private String msg;
    private Map<String, Object> data=new HashMap<>();
    public static Result success(String key, Object value){
        Result result=new Result();
        result.data.put(key, value);
        result.code=1;
        return result;
    }

    public static  Result error(String msg){
        Result result=new Result();
        result.code=0;
        result.msg=msg;
        return result;
    }
}
