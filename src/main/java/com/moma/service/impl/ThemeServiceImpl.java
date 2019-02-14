package com.moma.service.impl;

import com.moma.dao.bean.Theme;
import com.moma.dao.mapper.ThemeMapper;
import com.moma.service.ThemeService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Primary
@CacheConfig(cacheNames = {"theme"})
@Service
public class ThemeServiceImpl implements ThemeService {

    @Resource(type = ThemeMapper.class)
    ThemeMapper mapper;

    @Override
    @Cacheable(cacheManager = "jsonSerializer")
    public Theme getThemeAll(Integer id) {
        System.out.println("我去Theme家里玩");
        return mapper.getThemeAll(id);
    }
}
