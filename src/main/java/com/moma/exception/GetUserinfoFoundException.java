package com.moma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class GetUserinfoFoundException extends BaseException {

    public GetUserinfoFoundException(){
        super(ExceptionEnum.GET_USERINFO_FOUND);
    }
}
