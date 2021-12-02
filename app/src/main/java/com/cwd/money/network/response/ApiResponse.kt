package com.cwd.money.network.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ApiResponse(
    //var data: T?,
    //var code: String?,
    var message: String?
)
