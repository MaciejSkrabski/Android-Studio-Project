package com.example.projekt

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Parcel
import android.os.Parcelable
import android.provider.BaseColumns

object TableInfo: BaseColumns
{
    const val TABLE_NAME = "Zadania"
    const val TABLE_COLUMN_TITLE = "nazwa zadania"
    const val TABLE_COLUMN_DATE = "data dodania zadania"
    const val TABLE_COLUMN_PRIORITY = "priorytet zadania"
    const val TABLE_COLUMN_STATUS = "status zadania"
}

object BasicCommand{
    const val SQL_CREATE_TABLE =
        "CREATE TABLE ${TableInfo.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY, " +
                "${TableInfo.TABLE_COLUMN_TITLE} TEXT NOT NULL, " +
                "${TableInfo.TABLE_COLUMN_DATE} INT NOT NULL, " +
                "${TableInfo.TABLE_COLUMN_PRIORITY} INT NOT NULL, " +
                "${TableInfo.TABLE_COLUMN_STATUS} TEXT NOT NULL)"

    const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS ${TableInfo.TABLE_NAME}"
}

class DataBaseHelper(context: Context): SQLiteOpenHelper(context, TableInfo.TABLE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(BasicCommand.SQL_CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(BasicCommand.SQL_DELETE_TABLE)
        //onCreate(db)
    }
}