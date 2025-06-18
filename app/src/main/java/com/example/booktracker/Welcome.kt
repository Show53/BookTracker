package com.example.learning2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.booktracker.R
import com.google.android.material.button.MaterialButton

class Welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_page)

        val button0 = findViewById<MaterialButton>(R.id.welcome_page_button0)
        button0.setOnClickListener{
            val intent = Intent(this, Main::class.java)
            startActivity(intent)
            finish()
        }

        val button1 = findViewById<MaterialButton>(R.id.welcome_page_button1)
        button1.setOnClickListener{
            val intent = Intent(this, Registration::class.java)
            startActivity(intent)
            finish()
        }

        val button2 = findViewById<MaterialButton>(R.id.welcome_page_button2)
        button2.setOnClickListener{
            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
            finish()
        }

    }
}