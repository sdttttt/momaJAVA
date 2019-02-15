package com.moma.exception;

public class WxServiceErrorException extends BaseException {
    public WxServiceErrorException(){
        super(ExceptionEnum.WX_SERVICE_ERROR);
    }
}
