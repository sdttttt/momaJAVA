package com.moma;

import com.moma.dao.bean.Theme;
import com.moma.service.ThemeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Test
    public void contextLoads() {
//        Map<String,Object> map = new HashMap<>();
//        map.put("openID","123123123123123");
//        map.put("uid",555555555);
//        bannerRedisTemplate.opsForHash().put("fuck","123213",map);
   //     map = (Map<String,Object>) bannerRedisTemplate.opsForHash().get("fuck","123213");

        Theme ooo = themeService.getThemeAll(1);

        System.out.println(ooo.getName());

    }

}

