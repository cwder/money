package com.cwd.money.network

import com.cwd.money.request.bean.Share
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST

interface IApiService
{
    companion object {
        val service:IApiService by lazy {
            ApiBuilder.build(IApiService::class.java)
         }
    }

    @POST("/money/singleShare")
    suspend fun requestGetShare(code:String,pageNum:Int,pageSize:Int): List<Share>

}