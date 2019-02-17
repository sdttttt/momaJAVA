package com.moma.exception;

import org.springframework.http.HttpStatus;

public enum ExceptionEnum {
    BANNER_NOT_FOUNT("banner找不到了",10001,HttpStatus.NOT_FOUND),
    THEME_NOT_FOUNT("theme找不到了",10002, HttpStatus.NOT_FOUND),
    WX_SERVICE_ERROR("微信内部错误，无法获取openid",00000,HttpStatus.INTERNAL_SERVER_ERROR),
    UID_NOT("uid居然没有，怎么会有这种事情",20001,HttpStatus.NOT_FOUND),
    VERIFY_FOUND("验证结果消失了！",20002,HttpStatus.UNAUTHORIZED),
    GET_USERINFO_FOUND("无法获取用户信息",20003,HttpStatus.NOT_FOUND),
    TOKEN_ERROR("Token无效！",20004,HttpStatus.UNAUTHORIZED);

    private String message;
    private Integer err_code;
    private HttpStatus status;

    ExceptionEnum(String message,Integer err_code,HttpStatus status){
        this.message = message;
        this.err_code = err_code;
        this.status = status;
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

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
