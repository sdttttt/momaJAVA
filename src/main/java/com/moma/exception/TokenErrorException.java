package com.moma.exception;

public class TokenErrorException extends BaseException {

    public TokenErrorException() {
        super(ExceptionEnum.TOKEN_ERROR);
    }
}
