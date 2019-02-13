package com.moma.exception;

public class BannerNotFountException extends RuntimeException {

    private Integer err_code;

    public BannerNotFountException(ExceptionEnum exceptionEnum){
        super(exceptionEnum.getMessage());
        this.err_code = exceptionEnum.getErr_code();
    }

    public Integer getErr_code() {
        return err_code;
    }
}
