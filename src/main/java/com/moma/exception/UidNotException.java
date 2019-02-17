package com.moma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UidNotException extends BaseException {

    public UidNotException() {
        super(ExceptionEnum.UID_NOT);
    }
}
