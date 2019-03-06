package com.moma.dao.bean

import java.sql.Date

data class Category(
        var id : Long,
        var name : String,
        var img_id : Int? = null,
        var create_time : Date? = null,
        var delete_time : Date? =null,
        var product: List<Product>
)