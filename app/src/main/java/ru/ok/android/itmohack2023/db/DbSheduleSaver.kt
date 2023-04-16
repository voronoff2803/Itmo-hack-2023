package ru.ok.android.itmohack2023.db

import android.content.Context
import android.os.Build

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.annotation.RequiresApi

import ru.ok.android.itmohack2023.jsonparser.JsonParser


import com.github.kittinunf.fuel.httpPost
//import com.github.kittinunf.fuel.json.jsonBody
import com.github.kittinunf.fuel.core.extensions.jsonBody
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date


class DbSheduleSaver(_context: Context) {
    val context : Context = _context

    init{
        DbSingletone.initValue(_context)
        val mainHandler = Handler(Looper.getMainLooper())

        mainHandler.post(object : Runnable {
            override fun run() {

                    dbNewInfoSave()

                mainHandler.postDelayed(this, 120000 )
            }
        })
    }


    fun dbNewInfoSave (){
        var dbManager = DbManager(context);
        dbManager.openDb();
        //var dbmList = dbManager.readDbDataToDbModelList()
        //var jsonParser = JsonParser()
        //var jsonList = jsonParser.JSONArrayFromDbModelArray(dbManager)



        val tmp = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            DbModel(
                userID = "Inspector",
                client = "Client 1",
                time = "LocalDate.now()",
                headers = "Accept: application/json",
                type = "GET",
                path = "path",
                requestSize = "256",
                requestTime = "LocalDate.now()",
                statusCode = "200",
                methodName = "getUser",
                className = "UserController",
                other = "additional information",
                responseSize = "5"
            )
        } else {
            TODO("VERSION.SDK_INT < O")
        }

        dbManager.insertToDb(tmp)
    }

    fun sendPostRequest() {
        var dbManager = DbManager(context);
        dbManager.openDb();
        //var dbmList = dbManager.readDbDataToDbModelList()
        var jsonParser = JsonParser()
        var jsonList = jsonParser.JSONArrayFromDbModelArray(dbManager)
        val url = "http://192.168.26.243:5000/upload"
        val json = jsonList

        val (_, response, _) = url.httpPost()
            .header("Content-Type" to "application/json")
            .jsonBody(json.toString())
            .response()

        Log.d("tag", response.statusCode.toString())
    }

}