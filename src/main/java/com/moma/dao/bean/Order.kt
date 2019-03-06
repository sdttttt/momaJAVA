package com.moma.dao.bean

import java.math.BigDecimal
import java.util.*

data class Order(
        var id : Int,
        var oid : String,
        var snap : String,
        var price : BigDecimal,
        var title : String,
        var uid : Int,
        var create_time : Date,
        var delete_time : Date
)