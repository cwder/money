package com.cwd.money.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ApiBuilder {

    private var interceptor: Interceptor? = null
    private lateinit var converterFactory: Converter.Factory


    private val client:Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://192.168.3.56:8899")
            .client(createOkHttpClient())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    fun set(interceptor: Interceptor):ApiBuilder{
        this.interceptor = interceptor
        return this
    }

    private fun createOkHttpClient():OkHttpClient{
         return OkHttpClient.Builder()
             .connectTimeout(10,TimeUnit.SECONDS)
             .readTimeout(60,TimeUnit.SECONDS)
             .writeTimeout(60,TimeUnit.SECONDS).
             addInterceptor(HttpLoggingInterceptor().apply {
                 this.level = HttpLoggingInterceptor.Level.BODY
             }).apply {
                 this@ApiBuilder.interceptor?.let {
                     this.addInterceptor(interceptor!!)
                 }
             }.
             build()
    }



    fun <T> build(service: Class<T>): T {
        return client.create(service)
    }

}