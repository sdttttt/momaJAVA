package com.moma.service.impl

import com.moma.dao.bean.Category
import com.moma.dao.mapper.CategoryMapper
import com.moma.service.CategoryService
import org.springframework.stereotype.Service
import javax.annotation.Resource

@Service
class CategoryServiceImpl : CategoryService {

    @Resource
    lateinit var categoryMapper: CategoryMapper;

    override fun getProductAll(): Category {

        return categoryMapper.getProductAll();

    }
}