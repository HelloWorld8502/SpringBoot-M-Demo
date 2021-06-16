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
    private ResultMsg()
    {

    }
    public static ResultMsg  success(Object data){
        return new ResultMsg(0,"",data);

    }

    public static ResultMsg error()
    {
        return new ResultMsg(-1,"system error",null);
    }

    public static ResultMsg error(TestException e)
    {
        return new ResultMsg(e.getErrCode(),e.getMessage(),null);
    }
}
