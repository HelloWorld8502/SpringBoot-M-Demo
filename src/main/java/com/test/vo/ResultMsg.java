package com.test.vo;

import com.test.exception.TestException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: root
 * @date: 2021/6/16 23:55
 * @version: v1.0
 */
@Data
public class ResultMsg<T> {
    private int code;
    private String message;
    private T data;

    private ResultMsg(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    private ResultMsg() {

    }
    public static<T> ResultMsg<T>  success(T data){
        return new ResultMsg<T>(0,"",data);

    }

    public static ResultMsg<String> error()
    {
        return new ResultMsg<String>(-1,"system error",null);
    }

    public static ResultMsg<String> error(TestException e) {
        return new ResultMsg<String>(e.getErrCode(),e.getMessage(),null);
    }
}
