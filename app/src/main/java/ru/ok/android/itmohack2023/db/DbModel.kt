package ru.ok.android.itmohack2023.db

import android.icu.number.IntegerWidth
import java.time.LocalDate
import java.util.Date

class DbModel(
    val userID: String,
    val time: Date = Date(),
    val client: String,
    val path: String,
    val headers: String,
    val type: String,
    val requestTime: Date = Date(),
    val requestSize: Int,
    val responseSize: Int,
    val statusCode: Int,
    val methodName: String,
    val className: String,
    val other: String
) {

}
