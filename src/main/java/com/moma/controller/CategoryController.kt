package com.moma.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RequestMapping(value = ["/category"])
@RestController
class CategoryController {

    @GetMapping(value = ["/all"])
    public fun getProductAll() : String {
        return "这里是category";
    }

}