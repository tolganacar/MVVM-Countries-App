package com.tolganacar.kotlincountries.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tolganacar.kotlincountries.R
import com.tolganacar.kotlincountries.adapter.CountryAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}