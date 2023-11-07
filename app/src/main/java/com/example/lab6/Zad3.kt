package com.example.lab6

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Zad3 : AppCompatActivity() {

    private var isFragment1Displayed = true

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.zad3_layout_land)
        }else {
            setContentView(R.layout.zad3_layout)
        }
        val fragment1 = Fragment1()
        val fragment2 = Fragment2()

        // Wyświetl początkowo Fragment1
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment1)
            .commit()

        val switchToFragment1Button = findViewById<Button>(R.id.switchToFragment1Button)
        val switchToFragment2Button = findViewById<Button>(R.id.switchToFragment2Button)

        switchToFragment1Button.text = getString(R.string.button_fragment1)
        switchToFragment2Button.text = getString(R.string.button_fragment2)

        switchToFragment1Button.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment1)
                .commit()
        }

        switchToFragment2Button.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment2)
                .commit()
        }
    }
}