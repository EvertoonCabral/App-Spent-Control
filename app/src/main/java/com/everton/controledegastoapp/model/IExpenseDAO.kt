package com.everton.controledegastoapp.model

interface IExpenseDAO {

    fun save(expense:Expense) : Boolean
    fun edit(expense: Expense) : Boolean
    fun delete(idExpense: Int) : Boolean
    fun listExpense() : List<Expense>

}