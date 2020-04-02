package com.example.appfornewdevs.api

import android.content.Context
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    private val BASE_URL = "https://restcountries.eu/rest/v2/"

    fun getAppServices(context: Context): ApiServices {
        return getRetrofit(context).create(ApiServices::class.java)
    }


    private fun getRetrofit(context: Context): Retrofit {
        val retrofitBuilder = Retrofit.Builder()

        retrofitBuilder.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        retrofitBuilder.addConverterFactory(GsonConverterFactory.create())
        retrofitBuilder.client(getOkHttp(context))
        retrofitBuilder.baseUrl(BASE_URL)
        return retrofitBuilder.build()
    }

    private fun getOkHttp(context: Context): OkHttpClient {
        val okBuilder = OkHttpClient.Builder()

        okBuilder.interceptors().add(getHeaderInterceptor(context))
        return okBuilder.build()
    }

    private fun getHeaderInterceptor(context: Context): Interceptor? {
        return Interceptor { chain ->
            val requestBuilder = chain.request().newBuilder()
            requestBuilder.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
            requestBuilder.header("Content-Type", "application/vnd.api+json")
            chain.proceed(requestBuilder.build())
        }
    }

}