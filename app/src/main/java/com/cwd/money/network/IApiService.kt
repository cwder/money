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
    @GET("share")
    suspend fun requestGetShare(): Share

    companion object{
        private const val BASE_URL = "http://"
        private var service:IApiService? = null


        fun getApi():IApiService{
            if(null == service){
                val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
                    this.level = HttpLoggingInterceptor.Level.BASIC
                }

                val client = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()
                val retrofit = Retrofit.Builder().baseUrl(BASE_URL).client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                service = retrofit.create(IApiService::class.java)
            }
            return service!!

        }




    }


}