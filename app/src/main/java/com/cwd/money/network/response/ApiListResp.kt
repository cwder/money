package com.cwd.money.network.response

import com.cwd.money.network.bean.ShareInfo
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ApiListResp<T> (
   val pageNum:Int?,
   val pageSize:Int?,
   val totalPage:Int?,
   val total:Int?,
   val list:List<T>
)