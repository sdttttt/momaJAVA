package com.moma.service.impl;

import com.moma.config.WeChatConfig;
import com.moma.exception.ExceptionEnum;
import com.moma.exception.WxServiceErrorException;
import com.moma.service.TokenService;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


/*
 * 关于这个请求发送和处理我想了很久，也参考的很多文档
 * 首先微信返回的请求不是text/json 而是 text/plani 格式的
 * 参考https://www.cnblogs.com/softidea/p/8000483.html
 * 我在config包里面扩展了关于 text/plani的ContextType的格式处理
 * 返回请求的处理直接使用JSONObject我发现回返回值为空
 * 我使用了兼容性比较好的Object超类，来解决这个问题
 * 最后将Object强转为HashMap可以返回json数据
 * */

@Service
public class TokenServiceImpl implements TokenService {

    @Resource
    RestTemplate restTemplate;

    @Resource
    WeChatConfig weChatConfig;

    @Override
    public Map<String,Object> getToken(String code) {
        Map<String,Object> map = sendGetOpenid(code);
        if(map.containsKey("errmsg") || map.containsKey("errcode")){
            throw new WxServiceErrorException();
        }

        return map;
    }

    //辅助getToken API
    public Map<String,Object> sendGetOpenid(String code){
        //组装URL
        String loginUrl = String.format(weChatConfig.getLoginUrl(),weChatConfig.getAppid(),weChatConfig.getAppsecret(),code);
        //测试用
        System.out.println(loginUrl);
        //发送请求
        Object result = restTemplate.getForEntity(loginUrl, Object.class).getBody();
        //转化请求
        Map<String,Object> map = (HashMap<String,Object>) result;

        return map;
    }

}
