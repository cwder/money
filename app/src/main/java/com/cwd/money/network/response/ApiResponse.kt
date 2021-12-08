package com.cwd.money.network.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ApiResponse<T>(
    var message: String?,
    var code:Int?,
    var data:T
)
