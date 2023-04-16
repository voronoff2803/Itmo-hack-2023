package ru.ok.android.itmohack2023.db

import android.annotation.SuppressLint
import android.content.Context

@SuppressLint("StaticFieldLeak")
object DbSingletone {
    lateinit var context: Context
    fun initValue(context_ : Context) {
        context = context_
    }
//    fun getContext() : Context {
//        return context
//    }

}