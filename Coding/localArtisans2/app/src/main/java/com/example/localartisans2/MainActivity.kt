package com.example.localartisans2

import android.app.Application
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.localartisans2.databinding.ActivityMainBinding
import com.example.localartisans2.screens.app.LocalArtisan
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

    class MainActivity : AppCompatActivity() {

        lateinit var binding: ActivityMainBinding

        lateinit var auth: FirebaseAuth

        val database: FirebaseDatabase = FirebaseDatabase.getInstance()

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            enableEdgeToEdge()
            setContentView(R.layout.activity_main)
            auth = FirebaseAuth.getInstance()

            val currentUser = auth.currentUser
            if (currentUser != null) {
                updateUI(currentUser)
            }

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
            setContent {
                // add function localArtisans from localArtisanApp.kt
                LocalArtisan()

            }
        }

        private fun updateUI(currentUser: FirebaseUser) {
            //TODO: GO To screen related to type of user:
            // 1. Artisan
            // 2. Customer

        }
    }

