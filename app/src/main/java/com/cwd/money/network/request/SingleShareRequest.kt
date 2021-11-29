package com.cwd.money.network.request

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SingleShareRequest(
    val code:Int,
    val pageNum:Int,
    val pageSize:Int
)