package com.example.lab6

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Zad2 : AppCompatActivity() {

    private val sharedPreferencesFileName = "MojeSharedPreferences"

    private val textKey = "wprowadzonyTekst"

    private lateinit var textInput: EditText
    private lateinit var saveButton: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.zad2_layout)

        textInput = findViewById<EditText>(R.id.textInput)
        saveButton = findViewById<Button>(R.id.saveButton)

        sharedPreferences = getSharedPreferences(sharedPreferencesFileName, Context.MODE_PRIVATE)

        val savedText = sharedPreferences.getString(textKey, "")
        textInput.setText(savedText)

        saveButton.setOnClickListener {
            val enteredText = textInput.text.toString()

            with(sharedPreferences.edit()) {
                putString(textKey, enteredText)
                apply()
            }
        }
    }
}