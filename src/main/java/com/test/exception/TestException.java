package com.test.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: root
 * @date: 2021/6/16 23:38
 * @version: v1.0
 */
@Data
public class TestException extends RuntimeException{
    int errCode;


    public TestException() {
    }

    public TestException(int errCode) {
        this.errCode = errCode;
    }

    public TestException(String message, int errCode) {
        super(message);
        this.errCode = errCode;
    }

    public TestException(String message, Throwable cause, int errCode) {
        super(message, cause);
        this.errCode = errCode;
    }

    public TestException(Throwable cause, int errCode) {
        super(cause);
        this.errCode = errCode;
    }

    public TestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int errCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errCode = errCode;
    }
}
