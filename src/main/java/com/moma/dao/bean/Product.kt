package com.moma.dao.bean

import java.math.BigDecimal
import java.util.*

data class Product (
        var id : Int,
        var name : String,
        var price : BigDecimal,
        var stock : Int,
        var info : String,
        var category_id : Int,
        var img_id : Int,
        var create_time : Date,
        var update_time : Date,
        var delete_time : Date,
        var image : Image
)