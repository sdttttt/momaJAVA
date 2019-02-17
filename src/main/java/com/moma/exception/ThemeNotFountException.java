package com.moma.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ThemeNotFountException extends BaseException {

    public ThemeNotFountException(){
        super(ExceptionEnum.THEME_NOT_FOUNT);
    }
}
