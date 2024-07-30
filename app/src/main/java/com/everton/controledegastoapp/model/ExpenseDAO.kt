package com.everton.controledegastoapp.model

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.everton.controledegastoapp.database.DataBaseHelper

class ExpenseDAO(context: Context) : IExpenseDAO {

    val write = DataBaseHelper(context).writableDatabase
    val read = DataBaseHelper(context).readableDatabase



    override fun save(expense: Expense): Boolean {

        val values = ContentValues()
        values.put(DataBaseHelper.ID_EXPENSE, expense.id)
        values.put(DataBaseHelper.EXPENSE_NAME, expense.name)
        values.put(DataBaseHelper.AMOUNT, expense.amount)
        values.put(DataBaseHelper.DATE, expense.date)

        try{
            write.insert(DataBaseHelper.ID_EXPENSE,
                null,
                values
                )

            Log.i("Info_db", "Expense Salved")

        }catch (e: Exception){

            Log.i("Info_db", "ERROR! Expense insert.")

            return false

        }

        return true
    }

    override fun edit(expense: Expense): Boolean {
        TODO("Not yet implemented")
    }

    override fun delete(idExpense: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun listExpense(): List<Expense> {
        TODO("Not yet implemented")
    }
}