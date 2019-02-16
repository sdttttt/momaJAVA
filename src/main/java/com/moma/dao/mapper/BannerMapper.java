package com.moma.dao.mapper;

import com.moma.dao.bean.Banner;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BannerMapper {

    Banner getBannerAll(Integer id);

}
