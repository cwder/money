package com.cwd.money.network

import com.cwd.money.network.request.SingleShareRequest
import com.cwd.money.network.response.ApiResponse
import com.cwd.money.network.response.SingleShareResp
import com.cwd.money.request.bean.Share
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

val apiService :IApiService by lazy {
    ApiBuilder.build(IApiService::class.java)
}


interface IApiService
{
    @POST("/money/singleShare")
    suspend fun requestGetShare(@Body request: SingleShareRequest): ApiResponse

}