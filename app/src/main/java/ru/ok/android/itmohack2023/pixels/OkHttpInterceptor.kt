package ru.ok.android.itmohack2023.pixels
//package com.example.okhttpinterceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class OkHttpInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        // Get the request
        val request = chain.request()
        val requestBody = request.body

        // Analyze the request
        Log.d("OkHttp Request", "Url: ${request.url}")
        Log.d("OkHttp Request", "Method: ${request.method}")
        Log.d("OkHttp Request", "Body: ${requestBody?.toString()?.length}")

        val exception = Exception()
        val stackTrace = exception.stackTrace

        for (i in stackTrace) {
            Log.d("OkHttp Request", i.className)
            Log.d("OkHttp Request", i.methodName)
        }

        // Get the response
        val response = chain.proceed(request)
        val responseBody = response.body

        // Analyze the response
        Log.d("OkHttp Response", "Url: ${request.url}")
        Log.d("OkHttp Response", "Status code: ${response.code}")
        Log.d("OkHttp Response", "Body: ${responseBody?.toString()?.length}")

        return response
    }
}