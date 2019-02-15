package com.moma.dao.mapper;

import com.moma.dao.bean.Banner;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BannerMapper {

    // 这个sql语句有点复杂改为使用Mapper XML 配置方式
    Banner getBannerAll(Integer id);

}
