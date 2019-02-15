package com.moma.controller;

import com.moma.exception.VerifyFoundException;
import com.moma.service.TokenService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class TokenController {

    @Resource
    TokenService tokenService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map<String,Object> getToken(@RequestParam(value = "code") String code){

        return tokenService.getToken(code);
    }

    @RequestMapping(value = "/verify")
    public Map<String,Object> verify(@RequestHeader("token") String token){

        Map<String,Object> result = tokenService.checkToken(token);
        if(result == null)
            throw new VerifyFoundException();

        return result;
    }

}
