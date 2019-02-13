package com.moma.service.impl;

import com.moma.dao.bean.Banner;
import com.moma.dao.mapper.BannerMapper;
import com.moma.service.BannerService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BannerServiceImpl implements BannerService {

    @Resource(type = BannerMapper.class)
    BannerMapper mapper;

    @Override
    @Cacheable(cacheNames = "banner")
    public Banner getBannerAll(Integer id) {
        System.out.println("我去找banner玩了");
        return mapper.getBannerAll(id);
    }
}
