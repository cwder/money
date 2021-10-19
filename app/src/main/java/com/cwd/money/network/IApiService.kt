package com.cwd.money.network

import com.cwd.money.request.bean.Share
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface IApiService
{
    companion object {
        val service:IApiService by lazy {
            ApiBuilder.build(IApiService::class.java)
         }
    }

    @GET("share")
    suspend fun requestGetShare(): Share

}