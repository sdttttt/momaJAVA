package com.moma.controller;

import com.moma.dao.bean.Banner;
import com.moma.exception.BannerNotFountException;
import com.moma.exception.ExceptionEnum;
import com.moma.service.BannerService;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;

@RestController
public class BannerController{

    @Resource
    BannerService bannerService;

    @RequestMapping(value = "/banner/{id}",method = RequestMethod.GET)
    public Banner getBannerAll(@PathVariable("id") Integer id) throws BannerNotFountException {
        Banner result = bannerService.getBannerAll(id);
        if(result == null){
            throw new BannerNotFountException();
        }
        return result;
    }

}
