package com.moma.exception;

/*
 *   2019-2-13
 *   我终究还是太嫩了，
 *   这个异常处理想了一个小时还是想不出有什么优雅的方式写
 *
 *   2019-2-15
 *   我终于想出了一种比较优雅的处理异常方式
 *   枚举可真是个好东西
 *
 *   2019-2-17
 *   发现这种异常处理方式还是有诟病
 *   还是寻找出路吧
 *
 *   2019-2-18
 *   终于功夫不负有心人
 *   我在某位大牛的异常处理博客上吸收到了一种新的异常处理类用法
 * */

import org.springframework.http.HttpStatus;

public class BaseException extends RuntimeException {
    public String message;
    public Integer err_code;
    public HttpStatus status;

    public BaseException(ExceptionEnum ex) {
        this.message = ex.getMessage();
        this.err_code = ex.getErr_code();
        this.status = ex.getStatus();
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

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
