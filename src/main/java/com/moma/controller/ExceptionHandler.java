package com.moma.controller;

import com.moma.exception.BannerNotFountException;
import com.moma.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@ResponseBody
public class ExceptionHandler {

    /*
    * 这真的是最后的波纹了
    * 利用ResponseEntity完全定制Response请求
    * */

    @org.springframework.web.bind.annotation.ExceptionHandler(BaseException.class)
    public ResponseEntity<Map<String, Object>> wechatExceptionHandler(BaseException e){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("message",e.getMessage());
        map.put("err_code",e.getErr_code());

        return new ResponseEntity<Map<String, Object>>(map,e.getStatus());
    }
}
