package ru.ok.android.itmohack2023

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.ok.android.itmohack2023.db.DbManager
import ru.ok.android.itmohack2023.db.DbModel
import ru.ok.android.itmohack2023.db.DbSheduleSaver
import java.text.SimpleDateFormat
import java.util.Date

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.url_connection).setOnClickListener {
            startActivity(Intent(this, UrlConnectionActivity::class.java))
        }
        findViewById<View>(R.id.make_crash).setOnClickListener {
            0 / 0
        }
        findViewById<View>(R.id.web_view_button).setOnClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))
        }
        findViewById<View>(R.id.jni_button).setOnClickListener {
            startActivity(Intent(this, JNIActivity::class.java))
        }
        findViewById<View>(R.id.curl).setOnClickListener {
            startActivity(Intent(this, CurlActivity::class.java))
        }
        findViewById<View>(R.id.ok_http).setOnClickListener {
            startActivity(Intent(this, OkHttpActivity::class.java))
        }
        findViewById<View>(R.id.exo_player).setOnClickListener {
            startActivity(Intent(this, ExoPlayerActivity::class.java))
        }
        findViewById<View>(R.id.fresco).setOnClickListener {
            startActivity(Intent(this, FrescoActivity::class.java))
        }
        findViewById<View>(R.id.retrofit).setOnClickListener {
            startActivity(Intent(this, RetrofitActivity::class.java))
        }
        findViewById<View>(R.id.glide).setOnClickListener {
            startActivity(Intent(this, GlideActivity::class.java))
        }
        findViewById<View>(R.id.picasso).setOnClickListener {
            startActivity(Intent(this, PicassoActivity::class.java))
        }
        findViewById<View>(R.id.downloadmanager).setOnClickListener {
            startActivity(Intent(this, DownloadManagerActivity::class.java))
        }

//        val tmp = DbModel(
//            userID = "Inspector",
//            client = "Client 1",
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
//        Log.d("DbModel", "userID: ${tmp.userID}")
//        Log.d("DbModel", "time: ${tmp.time}")
//        Log.d("DbModel", "client: ${tmp.client}")
//        Log.d("DbModel", "path: ${tmp.path}")
//        Log.d("DbModel", "headers: ${tmp.headers}")
//        Log.d("DbModel", "type: ${tmp.type}")
//        Log.d("DbModel", "requestTime: ${tmp.requestTime}")
//        Log.d("DbModel", "requestSize: ${tmp.requestSize}")
//        Log.d("DbModel", "responseSize: ${tmp.responseSize}")
//        Log.d("DbModel", "statusCode: ${tmp.statusCode}")
//        Log.d("DbModel", "methodName: ${tmp.methodName}")
//        Log.d("DbModel", "className: ${tmp.className}")
//        Log.d("DbModel", "other: ${tmp.other}")


        val dbSheduleSaver = DbSheduleSaver (this)
        dbSheduleSaver.sendPostRequest();

    }

}