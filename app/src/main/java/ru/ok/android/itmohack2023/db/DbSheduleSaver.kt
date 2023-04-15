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
        val sdf = SimpleDateFormat("yyyy:MM:dd hh:mm:ss")
        val currentDate = sdf.format(Date())
        dbManager.insertToDb(currentDate, "Title N", "saving by shadule", )
    }

}