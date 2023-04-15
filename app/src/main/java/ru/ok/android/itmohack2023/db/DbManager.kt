package ru.ok.android.itmohack2023.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import java.text.SimpleDateFormat

class DbManager(context: Context) {
    val dbHelper = DbHelper(context)
    var db: SQLiteDatabase? = null

    fun openDb(){
        db = dbHelper.writableDatabase
    }

    fun insertToDb (dbModel: DbModel){


        val sdf = SimpleDateFormat("yyyy:MM:dd hh:mm:ss")
        val time1 = sdf.format(dbModel.time)
        val time2 = sdf.format(dbModel.requestTime)

        val values = ContentValues().apply {
            put(DbNameClass.COLUMN_NAME_USERID, dbModel.userID)
            put(DbNameClass.COLUMN_NAME_TIME, time1)
            put(DbNameClass.COLUMN_NAME_CLIENT, dbModel.client)
            put(DbNameClass.COLUMN_NAME_PATH, dbModel.path)
            put(DbNameClass.COLUMN_NAME_HEADERS, dbModel.headers)
            put(DbNameClass.COLUMN_NAME_TYPE, dbModel.type)
            put(DbNameClass.COLUMN_NAME_REQUESTTIME, time2)
            put(DbNameClass.COLUMN_NAME_REQUESTSIZE, dbModel.requestSize)
            put(DbNameClass.COLUMN_NAME_RESPONSESIZE, dbModel.responseSize)
            put(DbNameClass.COLUMN_NAME_STATUSCODE, dbModel.statusCode)
            put(DbNameClass.COLUMN_NAME_METHODNAME, dbModel.methodName)
            put(DbNameClass.COLUMN_NAME_CLASSNAME, dbModel.className)
            put(DbNameClass.COLUMN_NAME_OTHER, dbModel.other)
        }
        db?.insert(DbNameClass.TABLE_NAME, null, values)
    }

    @SuppressLint("Range")
    fun readDbData(): ArrayList<String>{
        val dataList = ArrayList<String>()
        val cursor = db?.query(DbNameClass.TABLE_NAME, null, null, null,
            null,null, null)
        with (cursor){
            while (cursor?.moveToNext()!!){
                val dataText = cursor?.getString(cursor.getColumnIndex(DbNameClass.COLUMN_NAME_TIME))
                dataList.add(dataText.toString())
            }
        }


        return dataList
    }
}