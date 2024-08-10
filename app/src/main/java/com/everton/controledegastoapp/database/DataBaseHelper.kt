package com.everton.controledegastoapp.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DataBaseHelper(context:Context) : SQLiteOpenHelper(context, "Banco.db", null, 1) {


   companion object{

       const val EXPENSE_TABLE = "expense"
       const val ID_EXPENSE = "id_expense"
       const val EXPENSE_NAME = "name"
       const val AMOUNT = "amount"
       const val DATE = "date"
       const val TYPE_EXPENSE = "type_expense"

   }


    override fun onCreate(db: SQLiteDatabase?) {

    val sql = ("CREATE TABLE IF NOT EXISTS $EXPENSE_TABLE ("+
            "$ID_EXPENSE INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"+
            "$EXPENSE_NAME VARCHAR(55)," +
            "$AMOUNT NOT NULL,"+
            "$DATE NOT NULL DEFAULT CURRENT_TIMESTAMP," +
            "$TYPE_EXPENSE TEXT" +
            ");")

        //Padrão para ter mais segurança para nao errar o nome das tabelas e colunas nos comandos


        Log.i("info_db", "Expense table created")

        try{
            db?.execSQL(sql)
        }catch (e:Exception){
            e.printStackTrace()

            Log.i("Info_db","Error creating expense table")


        }


    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}