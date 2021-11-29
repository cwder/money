package com.cwd.money.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

object ApiBuilder {

    private var interceptor: Interceptor? = null
    private lateinit var converterFactory: Converter.Factory
    private var url: String = "http://47.101.129.61:8899"


    private val client:Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(this.url)
            .client(createOkHttpClient())
            .addConverterFactory(this.converterFactory)
            .build()
    }

    fun set(interceptor: Interceptor):ApiBuilder{
        this.interceptor = interceptor
        return this
    }

    private fun createOkHttpClient():OkHttpClient{
         return OkHttpClient.Builder()
             .connectTimeout(10,TimeUnit.SECONDS)
             .readTimeout(10,TimeUnit.SECONDS)
             .writeTimeout(10,TimeUnit.SECONDS).
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