package ru.ok.android.itmohack2023.db

import android.provider.BaseColumns

object DbNameClass : BaseColumns {
    const val TABLE_NAME = "traffic"
    const val COLUMN_NAME_TITLE = "title"
    const val COLUMN_NAME_CONTENT = "subtitle"
    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "Pixels.db"

    //const val CREAT_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
    //        "${BaseColumns._ID} INTEGER PRIMARY KEY,$COLUMN_NAME_TITLE TEXT,$COLUMN_NAME_CONTENT TEXT)"

    const val SQL_CREATE_ENTRIES =
        "CREATE TABLE IF NOT EXISTS ${TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${COLUMN_NAME_TITLE} TEXT," +
                "${COLUMN_NAME_CONTENT} TEXT)"

    const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS ${TABLE_NAME}"


}