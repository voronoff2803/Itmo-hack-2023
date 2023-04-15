package ru.ok.android.itmohack2023.pixels
//package com.example.okhttpinterceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class OkHttpInterceptor() : Interceptor {


    fun interceptRequest(request: Request): Request {
        Log.d("OKHTTP REQUEST", request.toString())
        return request
    }


    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val interceptedRequest = interceptRequest(originalRequest)
        return chain.proceed(interceptedRequest)
    }
}