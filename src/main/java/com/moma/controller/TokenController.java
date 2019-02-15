package com.moma.controller;

import com.moma.exception.VerifyFoundException;
import com.moma.service.TokenService;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class TokenController {

    @Resource
    TokenService tokenService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map<String,Object> getToken(@RequestBody Map<String,Object> map){
        String code = (String) map.get("code");
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
