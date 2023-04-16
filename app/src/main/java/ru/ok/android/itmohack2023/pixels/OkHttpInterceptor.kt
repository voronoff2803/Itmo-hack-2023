package ru.ok.android.itmohack2023.pixels
//package com.example.okhttpinterceptor

import android.annotation.SuppressLint
import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import ru.ok.android.itmohack2023.db.DbManager
import ru.ok.android.itmohack2023.db.DbModel
import ru.ok.android.itmohack2023.db.DbSheduleSaver
import ru.ok.android.itmohack2023.db.DbSingletone

class OkHttpInterceptor : Interceptor {

    @SuppressLint("HardwareIds")
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
        Log.d("OkHttp Response", "Url: ${response.request.url}")
        Log.d("OkHttp Response", "Status code: ${response.code}")
        Log.d("OkHttp Response", "Body: ${responseBody?.toString()?.length}")

        val app = ApplicationId()
        val androidId = app.getAndroidId()

        val modelInstance = DbModel(userID = androidId.toString(),
            path = request.url.toString(),
            type = request.method,
            requestSize = requestBody.toString().length.toString(),
            className = stackTrace[3].className,
            methodName = stackTrace[3].methodName,
            statusCode = response.code.toString(),
            responseSize = responseBody.toString().length.toString()
        )
        val tmpDb = DbManager (DbSingletone.context)
        tmpDb.insertToDb(modelInstance)
        return response
    }
}