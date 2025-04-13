package com.example.order_online.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private String code;
    private String message;
    private Object data;
    public static Result success(String msg){
        return new Result(Constants.CODE_200,msg,null);
    }
    public static Result success(Object data){
        return new Result(Constants.CODE_200,"success",data);
    }
    public static Result error(String code, String msg) {
        return new Result(code, msg, null);
    }
    public static Result error() {
        return new Result(Constants.CODE_500, "系统错误", null);
    }
}
