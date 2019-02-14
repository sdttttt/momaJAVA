package com.moma.exception;

public enum ExceptionEnum {
    BANNER_NOT_FOUNT("banner找不到了",10001),
    THEME_NOT_FOUNT("theme找不到了",10002);

    private String message;
    private Integer err_code;

    ExceptionEnum(String message,Integer err_code){
        this.message = message;
        this.err_code = err_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getErr_code() {
        return err_code;
    }

    public void setErr_code(Integer err_code) {
        this.err_code = err_code;
    }
}
