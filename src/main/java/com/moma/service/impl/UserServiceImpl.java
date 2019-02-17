package com.moma.service.impl;

import com.moma.dao.mapper.UserMapper;
import com.moma.exception.TokenErrorException;
import com.moma.service.UserService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Resource
    RedisTemplate jsonRedisTemplate;

    @Override
    public Map<String, Object> getMyWallet(String token) {
        String openid = getOpenidByTokenFromRedis(token);
        BigDecimal wallet = userMapper.getWalletByOpenid(openid);
        Map<String,Object> map = new HashMap<>();
        map.put("wallet",wallet);
        return map;
    }

    //辅助 getMyWallet API
    private String getOpenidByTokenFromRedis(String token){
        boolean Not = jsonRedisTemplate.hasKey(token);
            /*
        BUG之一
        用户可能长时间停留在界面滞停
        导致token过期之后来请求user数据
        小程序应该在接收到 401 状态码之后
        马上重新请求token数据
        * */
        if(!Not)
            throw new TokenErrorException();
       Map<String,Object> map = (HashMap<String, Object>) jsonRedisTemplate.opsForValue().get(token);

       return (String) map.get("openid");
    }

}
