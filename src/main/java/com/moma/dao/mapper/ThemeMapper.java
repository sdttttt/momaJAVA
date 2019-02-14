package com.moma.dao.mapper;

import com.moma.dao.bean.Theme;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ThemeMapper {

    Theme getThemeAll(Integer id);

}
