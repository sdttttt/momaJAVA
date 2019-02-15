package com.moma;

import com.moma.config.WeChatConfig;
import com.moma.dao.bean.Theme;
import com.moma.service.ThemeService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MomaApplicationTests {

//    @Resource(type = BannerService.class)
//    BannerService bannerService;

//    @Resource(name = "redisTemplate")
//    RedisTemplate bannerRedisTemplate;

    @Resource
    ThemeService themeService;

    @Resource
    WeChatConfig weChatConfig;

    @Resource
    RestTemplate restTemplate;

    @Test
    public void contextLoads() throws JSONException {
//        Map<String,Object> map = new HashMap<>();
//        map.put("openID","123123123123123");
//        map.put("uid",555555555);
//        bannerRedisTemplate.opsForHash().put("fuck","123213",map);
   //     map = (Map<String,Object>) bannerRedisTemplate.opsForHash().get("fuck","123213");

        String abc = "http://www.moma.com/index.php/api/v1/banner/1";
        Object json = restTemplate.getForEntity(abc, Object.class).getBody();
        Map<String,String> map = (HashMap<String, String>) json;
        System.out.println(map.toString());



    }

}

