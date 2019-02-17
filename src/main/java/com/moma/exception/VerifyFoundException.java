package com.moma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class VerifyFoundException extends BaseException {

    public VerifyFoundException(){
        super(ExceptionEnum.VERIFY_FOUND);
    }
}
