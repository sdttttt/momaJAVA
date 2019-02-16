package com.moma.controller;

import com.moma.exception.GetUserinfoFoundException;
import com.moma.service.UserService;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping(value = "/wallet",method = RequestMethod.POST)
    public Map<String,Object> getMyWallet(@RequestHeader("token") String token){
        Map<String,Object> result = userService.getMyWallet(token);
        if(result.get("wallet") == null)
            throw new GetUserinfoFoundException();

        return result;
    }
}
