package ru.ok.android.itmohack2023
//package com.example.okhttpinterceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class OkHttpInterceptor(private val interceptor: RequestInterceptor) : Interceptor {

    interface RequestInterceptor {
        fun interceptRequest(request: Request): Request
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        Log.d("Tag", originalRequest.toString())
        val interceptedRequest = interceptor.interceptRequest(originalRequest)
        return chain.proceed(interceptedRequest)
    }
}