package com.moma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class BannerNotFountException extends BaseException {

    public BannerNotFountException(){
        super(ExceptionEnum.BANNER_NOT_FOUNT);
    }
}
