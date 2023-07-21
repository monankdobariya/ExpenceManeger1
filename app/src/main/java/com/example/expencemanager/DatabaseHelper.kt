package com.example.expencemanager

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.expencemanager.Model.AllDataModel
import com.example.expencemanager.Model.CategoryModel
import com.example.expencemanager.Model.ModemodelClass

class DatabaseHelper(
    var context: Context,
    var name: String,
    var factory: SQLiteDatabase.CursorFactory?,
    var version: Int
) :
    SQLiteOpenHelper(context, name, factory, version) {
    var list = ArrayList<CategoryModel>()
    var list2 = ArrayList<ModemodelClass>()
    var datalist = ArrayList<AllDataModel>()

    override fun onCreate(db: SQLiteDatabase?) {
        var createtable =
            "create table Databasetable(id Integer primary key autoincrement, name text )"
        db?.execSQL(createtable)

        var paymenttable = "create table Modetable(id Integer primary key autoincrement,mode text )"
        db?.execSQL(paymenttable)

        var datatable =
            "create table Alldatatable(id Integer primary key autoincrement,amount text,category text,date text,mode text,note text)"
        db?.execSQL(datatable)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insertData(name: String) {

        var c = ContentValues()
        c.put("name", name)

        var write = writableDatabase

        var result = write.insert("Databasetable", null, c)
        Log.e("TAG", "insertData: " + result)

    }

    fun displayCategory(): ArrayList<CategoryModel> {

        val db1 = readableDatabase
        var list = ArrayList<CategoryModel>()
        val sql = "select * from Databasetable"
        val cursor: Cursor = db1.rawQuery(sql, null)

        cursor.moveToFirst()
        do {
            var id = cursor.getInt(0)
            var category = cursor.getString(1)

            list.add(CategoryModel(category))
        } while (cursor.moveToNext())


        return list


    }

    fun modeinsertData(mode: String) {

        var c = ContentValues()
        c.put("mode", mode)

        var write = writableDatabase

        var result = write.insert("Modetable", null, c)
        Log.e("TAG", "modeinsertData: " + result)

    }

    fun Dispalaymode(): ArrayList<ModemodelClass> {
        list2.clear()
        val db1 = readableDatabase
        val sql = "select * from Modetable"
        val cursor: Cursor = db1.rawQuery(sql, null)
        cursor.moveToFirst()
        do {
            val payment = cursor.getString(1)
            list2.add(ModemodelClass(payment))
        } while (cursor.moveToNext())
        return list2

    }

    fun alldatainsert(amount: String, note: String, category: String, mode: String, date: String,) {
        var c = ContentValues()
        c.put("amount", amount)
        c.put("note", note)
        c.put("category", category)
        c.put("mode", mode)
        c.put("date",date)

        var write = writableDatabase

        var result = write.insert("Alldatatable", null, c)
        Log.e("TAG", "alldatainsert: " + result)
    }

    fun Alldatadispalay(): ArrayList<AllDataModel> {
        val db1 = readableDatabase
        val sql = "select * from Alldatatable"
        var cursor: Cursor = db1.rawQuery(sql, null)
        cursor.moveToFirst()
        do {
            var id =cursor.getInt(0)
            var amount = cursor.getString(1)
            var category=cursor.getString(2)
            var date=cursor.getString(3)
            var note=cursor.getString(4)
            datalist.add(AllDataModel(id,amount,category,date,note))
        } while (cursor.moveToNext())

        return datalist
    }
}
