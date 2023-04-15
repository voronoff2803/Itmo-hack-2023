package ru.ok.android.itmohack2023.db

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.ok.android.itmohack2023.db.DbManager
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Date


class DbSheduleSaver(_context: Context) {
    val context : Context = _context

    init{
        val mainHandler = Handler(Looper.getMainLooper())

        mainHandler.post(object : Runnable {
            override fun run() {
                dbNewInfoSave()
                mainHandler.postDelayed(this, 60000 )
            }
        })
    }

    fun dbNewInfoSave (){
        var dbManager = DbManager(context);
        dbManager.openDb();


//        val tmp = DbModel(
//            userID = "Inspector",
//            client = "Client 1",
//            time = LocalDate.now(),
//            path = "/api/v1/user",
//            headers = "Accept: application/json",
//            type = "GET",
//            requestSize = 256,
//            statusCode = 200,
//            methodName = "getUser",
//            className = "UserController",
//            other = "additional information",
//            responseSize = 5
//        )
//
//        dbManager.insertToDb(tmp)
    }

}