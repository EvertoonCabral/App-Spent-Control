package com.everton.controledegastoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.everton.controledegastoapp.databinding.ActivityAddExpenseBinding
import com.everton.controledegastoapp.model.Expense
import com.everton.controledegastoapp.model.ExpenseDAO

class AddExpenseActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddExpenseBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {

             val expenseName = binding.editExpense.text.toString().trim()
             val expenseAmount = binding.editExpenseAmount.text.toString().trim()
           //  val expenseDate = binding.editExpenseDate.text.toString().trim()

            if (expenseName.isEmpty() || expenseAmount.isEmpty() ) {
                Toast.makeText(this, "Please fill all the fields.", Toast.LENGTH_SHORT).show()
            }

            val amount = expenseAmount.toDouble()


            var expense = Expense(-1, expenseName,amount,"default","default")

            var expenseDAO = ExpenseDAO(this)


                try{

                    if(expenseDAO.save(expense))
                    Toast.makeText(this, "Expense save!", Toast.LENGTH_SHORT).show()

                    clearFields()

                }catch (e:Exception){
                    e.printStackTrace()
                    Toast.makeText(this, "Error to save Expense.", Toast.LENGTH_SHORT).show()

                }



            }




    }

    private fun clearFields() {
        binding.editExpense.text.clear()
        binding.editExpenseAmount.text.clear()
        binding.editExpenseDate.text.clear()
    }
}