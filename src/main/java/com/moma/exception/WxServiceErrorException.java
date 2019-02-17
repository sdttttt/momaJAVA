package com.moma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class WxServiceErrorException extends BaseException {
    public WxServiceErrorException(){
        super(ExceptionEnum.WX_SERVICE_ERROR);
    }
}
