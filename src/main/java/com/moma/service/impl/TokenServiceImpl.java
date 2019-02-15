package com.moma.service.impl;

import com.moma.Tools.Tools;
import com.moma.config.WeChatConfig;
import com.moma.dao.bean.User;
import com.moma.dao.mapper.UserMapper;
import com.moma.exception.UidNotException;
import com.moma.exception.WxServiceErrorException;
import com.moma.service.TokenService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Date;
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
    UserMapper userMapper;

    @Resource
    RestTemplate restTemplate;

    @Resource
    WeChatConfig weChatConfig;

    @Resource
    RedisTemplate jsonRedisTemplate;

    @Override
    public Map<String,Object> getToken(String code) {
        Map<String,Object> map = sendGetOpenid(code);
        if(map.containsKey("errmsg") || map.containsKey("errcode"))
            throw new WxServiceErrorException();

        String openid  = (String) map.get("openid");
        User user = userMapper.userByOpenid(openid);
        Integer uid;
        //BUG 修正
        //user.getOpenid == null
        //这种写法是错误的 既然user已经是空 何来getOpenid 之说？
        if(user == null)
           uid = createUserByOpenid(openid);
        else
            uid = user.getId();

        if(uid == 0)
            throw new UidNotException();

        String token = saveCache(openid,uid);
        Map<String,Object> tokenMap = new HashMap<>();
        tokenMap.put("token",token);

        return tokenMap;
    }

    //辅助getToken API
    private Map<String,Object> sendGetOpenid(String code){
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

    //辅助getToken API
    private Integer createUserByOpenid(String openid){
        User user = new User();
        user.setOpenid(openid);
        user.setCreate_time(new Date());
        user.setUpdate_time(new Date());

        try {
         userMapper.makeUser(user);
         return user.getId();
        }catch (Exception e){
            throw e;
        }
    }

    //辅助getToken API
    private String saveCache(String openid,Integer uid){
        String token = Tools.randChar();
        Map<String,Object> cache = new HashMap<String,Object>();
        cache.put("openid",openid);
        cache.put("uid",uid);
        //Redis 缓存
        try{
            jsonRedisTemplate.opsForValue().set(token,cache,1000);
        }catch (Exception e){
            throw e;
        }
        return token;
    }

    @Override
    public Map<String, Object> checkToken(String token) {
        Boolean check = jsonRedisTemplate.hasKey(token);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("verify",check);

        return map;
    }
}
