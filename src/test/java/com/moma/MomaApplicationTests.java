package com.moma;

import com.moma.config.WeChatConfig;
import com.moma.dao.bean.Banner;
import com.moma.dao.bean.User;
import com.moma.dao.mapper.UserMapper;
import com.moma.service.ThemeService;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MomaApplicationTests {

//    @Resource(type = BannerService.class)
//    BannerService bannerService;

    @Resource
    RedisTemplate jsonRedisTemplate;

    @Resource
    WeChatConfig weChatConfig;

    @Resource
    RestTemplate restTemplate;

    @Resource
    UserMapper userMapper;


    @Test
    public void contextLoads() throws JSONException {
//        Map<String,Object> map = new HashMap<>();
//        map.put("openID","123123123123123");
//        map.put("uid",555555555);
//        bannerRedisTemplate.opsForHash().put("fuck","123213",map);
   //     map = (Map<String,Object>) bannerRedisTemplate.opsForHash().get("fuck","123213");

//        String abc = "http://www.moma.com/index.php/api/v1/banner/1";
//        Object json = restTemplate.getForEntity(abc, Object.class).getBody();
//        Map<String,String> map = (HashMap<String, String>) json;
//        System.out.println(map.toString());


       // Date date = new java.sql.Date();

//        User user = new User();
//        user.setCreate_time(new Date());
//        user.setOpenid("21123123");
//        Integer re = userMapper.makeUser(user);


//        UUID token = UUID.randomUUID();
//        String[] dd = token.toString().split("-");
//        System.out.println(dd[0]+dd[1]+dd[2]);

//        Banner banner = new Banner();
//        banner.setId(1);
//        banner.setName("awdaw");
        Banner banner = (Banner) jsonRedisTemplate.opsForValue().get("banner");
        System.out.println(banner.getName());
        // System.out.println(.toString());
    }

}

