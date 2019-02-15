package com.moma.exception;

public class BaseException extends RuntimeException {
    public String message;
    public Integer err_code;

    public BaseException(ExceptionEnum ex) {
        this.message = ex.getMessage();
        this.err_code = ex.getErr_code();
    }

    @Override
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
