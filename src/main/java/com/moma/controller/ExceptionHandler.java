package com.moma.controller;

import com.moma.exception.BannerNotFountException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@ResponseBody
public class ExceptionHandler {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @org.springframework.web.bind.annotation.ExceptionHandler(BannerNotFountException.class)
    public Map<String,Object> wechatExceptionHandler(BannerNotFountException e){
        Map<String,Object> map = new HashMap<>();
        map.put("message",e.getMessage());
        map.put("err_code",e.getErr_code());

        return map;
    }
}
