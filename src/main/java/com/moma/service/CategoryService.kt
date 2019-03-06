package com.moma.service

import com.moma.dao.bean.Category

interface CategoryService {

    fun getProductAll() : Category;

}