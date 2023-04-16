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
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException
import java.net.URI
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
                userID = "UpdatingInspector",
                client = "Client 5",
                time = LocalDate.now().toString(),
                headers = "Accept: application/json",
                type = "GET",
                path = "upd path",
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
        var jsonbody = jsonList.toString()

        val (_, response, _) = url.httpPost()
            .header("Content-Type" to "application/json")
            //.jsonBody(json.toString())
            .body(jsonbody)
            .response()

        Log.d("tag", response.statusCode.toString())
    }

    fun postOkRequest(){
        val client = OkHttpClient()

        var dbManager = DbManager(context);
        dbManager.openDb();
        //var dbmList = dbManager.readDbDataToDbModelList()
        var jsonParser = JsonParser()
        var jsonList = jsonParser.JSONArrayFromDbModelArray(dbManager)


        //val requestBody = RequestBody.create(MediaType.parse("application/json"), json)
        val mediaType = "application/json; charset=utf-8".toMediaType()
        val requestBody = jsonList.toString().toRequestBody(mediaType)

        val request = Request.Builder()
            .url("http://192.168.26.243:5000/upload")
            .post(requestBody)
            .build()



        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                // обработка ошибки
            }

            override fun onResponse(call: Call, response: Response) {
                // обработка ответа сервера
            }
        })

        Log.d("tag", request.tag().toString())
    }


}