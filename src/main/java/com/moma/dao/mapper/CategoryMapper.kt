package com.moma.dao.mapper

import com.moma.dao.bean.Category
import org.apache.ibatis.annotations.Mapper

@Mapper
interface CategoryMapper {

    fun getProductAll() : Category;

}