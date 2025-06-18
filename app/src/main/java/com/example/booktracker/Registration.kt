package com.example.learning2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.booktracker.MainActivity
import com.example.booktracker.R
import com.google.android.material.button.MaterialButton

class Registration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_page)

        val button0 = findViewById<Toolbar>(R.id.registration_page_toolbar)
        button0.setOnClickListener{
            val intent = Intent(this, Welcome::class.java)
            startActivity(intent)
            finish()
        }

        val button1 = findViewById<MaterialButton>(R.id.registration_activity_button0)
        button1.setOnClickListener{
            val intent = Intent(this, Main::class.java)
            startActivity(intent)
            finish()
        }

    }
}