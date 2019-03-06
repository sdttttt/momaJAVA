package com.moma.dao.mapper

import com.moma.dao.bean.Product
import org.apache.ibatis.annotations.Mapper

@Mapper
interface CategoryMapper {

    fun getProductAll() : List<Product>;

}