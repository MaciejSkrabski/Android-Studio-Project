package com.example.projekt

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Parcel
import android.os.Parcelable
import android.provider.BaseColumns
import android.util.EventLog
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDate

object TableInfo: BaseColumns
{
    const val TABLE_NAME = "Zadania"
    const val TABLE_COLUMN_TITLE = "nazwa zadania"
    const val TABLE_COLUMN_DATE = "data dodania zadania"
    const val TABLE_COLUMN_PRIORITY = "priorytet zadania"
    const val TABLE_COLUMN_STATUS = "status zadania"
    const val TABLE_COLUMN_DESCRIPTION = "opis zadania"
}

object BasicCommand{
    const val SQL_CREATE_TABLE =
        "CREATE TABLE ${TableInfo.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "${TableInfo.TABLE_COLUMN_TITLE} TEXT NOT NULL, " +
                "${TableInfo.TABLE_COLUMN_DATE} TEXT NOT NULL, " +
                "${TableInfo.TABLE_COLUMN_PRIORITY} INT NOT NULL, " +
                "${TableInfo.TABLE_COLUMN_STATUS} TEXT NOT NULL)" +
                "${TableInfo.TABLE_COLUMN_DESCRIPTION} TEXT NOT NULL)"

    const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS ${TableInfo.TABLE_NAME}"

    const val SQL_INSERT =
            "INSERT INTO ${TableInfo.TABLE_NAME} (${TableInfo.TABLE_COLUMN_TITLE}, ${TableInfo.TABLE_COLUMN_DATE}, ${TableInfo.TABLE_COLUMN_PRIORITY}, ${TableInfo.TABLE_COLUMN_STATUS}) " +
            "VALUES( zad1, 02122019, 3, niewykonane);"

    const val SQL_SELECT =
        "SELECT * from ${TableInfo.TABLE_NAME} where ${TableInfo.TABLE_COLUMN_TITLE} like \"zad1\""
}

class Event {
    var id: Int? = null
    var title: String? = null
    var prio: Int? = null
    var date: String? = null
    var status: String? = null
    var desc: String? = null

    constructor()
    constructor(id: Int, title: String, prio: Int,/*status:String,*/desc: String) {
        this.id = id

        this.title = title
        this.prio = prio
        /*  this.status=status*/
        this.desc = desc
    }
}

    class DataBaseHelper(context: Context) :
        SQLiteOpenHelper(context, TableInfo.TABLE_NAME, null, 1) {

        val context = context

        override fun onCreate(db: SQLiteDatabase?) {
            db?.execSQL(BasicCommand.SQL_CREATE_TABLE)

        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            db?.execSQL(BasicCommand.SQL_DELETE_TABLE)
            //onCreate(db)
        }

        val List: ArrayList<Event>
            get() {

                val lstEvent = ArrayList<Event>()
                val selectQuery = "SELECT * FROM ${TableInfo.TABLE_NAME}"
                val db = this.writableDatabase
                val cursor = db.rawQuery(selectQuery, null)
                if (cursor.moveToFirst()) {
                    do {
                        val event = Event()
                        event.id = cursor.getInt(cursor.getColumnIndex(BaseColumns._ID))
                        event.title = cursor.getString(cursor.getColumnIndex(TableInfo.TABLE_NAME))
                        event.prio =
                            cursor.getInt(cursor.getColumnIndex(TableInfo.TABLE_COLUMN_PRIORITY))
                        event.desc =
                            cursor.getString(cursor.getColumnIndex(TableInfo.TABLE_COLUMN_DESCRIPTION))
                        event.status =
                            cursor.getString(cursor.getColumnIndex(TableInfo.TABLE_COLUMN_STATUS))
                        event.date =
                            cursor.getString(cursor.getColumnIndex(TableInfo.TABLE_COLUMN_DATE))
                        lstEvent.add(event)
                    } while (cursor.moveToNext())
                }
                return lstEvent
                db.close()

            }

        fun saveInfo(context: Context) {
            Toast.makeText(context, "pomyslnie dodano wydarzenie ", Toast.LENGTH_SHORT).show()
        }

        fun add_event(event: Event) {

            val db = writableDatabase
            val values = ContentValues()
            values.put(TableInfo.TABLE_COLUMN_DATE, java.util.Calendar.getInstance().toString())
            values.put(TableInfo.TABLE_COLUMN_STATUS, "Rozpoczęte")
            values.put(TableInfo.TABLE_COLUMN_DESCRIPTION, event.desc)
            values.put(TableInfo.TABLE_COLUMN_TITLE, event.title)
            values.put(TableInfo.TABLE_COLUMN_PRIORITY, event.prio)

            db.insertOrThrow(TableInfo.TABLE_NAME, null, values)
            saveInfo(context)
            db.close()

        }

        fun del_even(id: String) {

            val db = writableDatabase

            db.delete(TableInfo.TABLE_NAME, "${BaseColumns._ID}=?", arrayOf(id))
            Toast.makeText(context, "Pomyślnie usunięto wydarzenie", Toast.LENGTH_SHORT).show()
            db.close()
    }
}