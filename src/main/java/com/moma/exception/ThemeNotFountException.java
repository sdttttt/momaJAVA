package com.moma.exception;

public class ThemeNotFountException extends RuntimeException {

    private Integer err_code;

    public ThemeNotFountException(ExceptionEnum exceptionEnum){
        super(exceptionEnum.getMessage());
        this.err_code = exceptionEnum.getErr_code();
    }

    public Integer getErr_code() {
        return err_code;
    }
}
