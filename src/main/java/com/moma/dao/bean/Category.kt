package com.moma.dao.bean

import java.util.*

data class Category(
        var id : Int,
        var name : String,
        var img_id : Int,
        var create_time : Date,
        var delete_time : Date,
        var product: List<Product>
)