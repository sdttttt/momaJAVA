package com.moma.controller;

import com.moma.dao.bean.Banner;
import com.moma.exception.BannerNotFountException;
import com.moma.exception.ExceptionEnum;
import com.moma.service.BannerService;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;

@RestController
public class BannerController{

/*
*   我终究还是太嫩了，
*   这个异常处理想了一个小时还是想不出有什么优雅的方式写
* */

    @Resource
    BannerService bannerService;
    @GetMapping("/banner/{id}")
    public Banner getBannerAll(@PathVariable("id") Integer id) throws BannerNotFountException {
        Banner result = bannerService.getBannerAll(id);
        if(result == null){
            throw new BannerNotFountException(ExceptionEnum.BANNER_NOT_FOUNT);
        }
        return result;
    }

}
