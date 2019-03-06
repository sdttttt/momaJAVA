package com.moma.dao.bean

import java.math.BigDecimal
import java.sql.Date

data class Product (
        var id : Int,
        var name : String,
        var price : BigDecimal,
        var stock : Int,
        var info : String? = null,
        var category_id : Int,
        var img_id : Int,
        var create_time : Date? = null,
        var update_time : Date? = null,
        var delete_time : Date? = null,
        var image : Image
)