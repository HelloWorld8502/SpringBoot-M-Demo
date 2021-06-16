package com.test.exception;

import lombok.Data;


public enum TestExceptionEnum {

    TEST_EXCEPTION_ENUM(-1111,"TEST");
    int code;
    String message;

    TestExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    TestExceptionEnum() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
