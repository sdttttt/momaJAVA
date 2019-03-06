package com.moma.controller

import com.moma.dao.bean.Category
import com.moma.service.CategoryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource


@RequestMapping(value = ["/category"])
@RestController
class CategoryController {

    @Resource
    lateinit var categoryService: CategoryService;

    @GetMapping(value = ["/all"])
    public fun getProductAll() : Category {
        var result : Category = categoryService.getProductAll();


        return result;
    }

}