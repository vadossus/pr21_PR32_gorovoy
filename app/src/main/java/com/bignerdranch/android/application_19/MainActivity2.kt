package com.bignerdranch.android.application_19

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val fab = findViewById<FloatingActionButton>(R.id.fab)

        fab.setOnClickListener{ view ->
            Snackbar.make(view, "Вы нажали на FloatingActionButton", Snackbar.LENGTH_SHORT).show()
        }

    }
}