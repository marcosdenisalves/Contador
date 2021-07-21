package com.myproject.vmodelapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var txtCount: TextView
    lateinit var btnOne: Button
    lateinit var btnTwo: Button

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        initClick()
    }

    private fun initData() {
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        txtCount = findViewById(R.id.txt_count)
        btnOne = findViewById(R.id.btn_one)
        btnTwo = findViewById(R.id.btn_two)

        mainViewModel.mainCount.observe(this, Observer { valor ->
            txtCount.text = valor
        })
    }

    private fun initClick() {
        btnOne.setOnClickListener {
            mainViewModel.count()
        }

        btnTwo.setOnClickListener {
            Toast.makeText(
                applicationContext,
                "Valor contador: ${mainViewModel.mainCount.value}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}