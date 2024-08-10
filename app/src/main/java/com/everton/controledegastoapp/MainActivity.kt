package com.everton.controledegastoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.everton.controledegastoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.fabAdd.setOnClickListener {

        val intent = Intent(this, AddExpenseActivity::class.java)
            startActivity(intent)

        }



    }
}