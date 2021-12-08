package com.cwd.money.network

import com.cwd.money.network.bean.ShareInfo
import com.cwd.money.network.request.SingleShareRequest
import com.cwd.money.network.response.ApiListResp
import com.cwd.money.network.response.ApiResponse
import retrofit2.http.Body
import retrofit2.http.POST

val apiService :IApiService by lazy {
    ApiBuilder.build(IApiService::class.java)
}


interface IApiService
{
    @POST("/money/singleShare")
    suspend fun requestGetShare(@Body request: SingleShareRequest): ApiResponse<ApiListResp<ShareInfo>>

}