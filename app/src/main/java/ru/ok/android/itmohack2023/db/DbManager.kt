package ru.ok.android.itmohack2023.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class DbManager(context: Context) {
    val dbHelper = DbHelper(context)
    var db: SQLiteDatabase? = null

    fun openDb(){
        db = dbHelper.writableDatabase
    }

    fun insertToDb (time: String, title: String, content: String){
        val values = ContentValues().apply {
            put(DbNameClass.COLUMN_NAME_TIME, time)
            put(DbNameClass.COLUMN_NAME_TITLE, title)
            put(DbNameClass.COLUMN_NAME_CONTENT, content)
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
                val dataText = cursor?.getString(cursor.getColumnIndex(DbNameClass.COLUMN_NAME_TITLE))
                dataList.add(dataText.toString())
            }
        }


        return dataList
    }
}