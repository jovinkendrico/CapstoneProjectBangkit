package com.example.capstoneproject.ui.auth.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.capstoneproject.R
import com.example.capstoneproject.databinding.ActivityLoginBinding
import com.example.capstoneproject.ui.auth.AuthViewModelFactory

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel by viewModels<LoginViewModel> {
        AuthViewModelFactory.getInstance(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progressBar.visibility = View.GONE

        binding.loginButton.setOnClickListener{
            val username = binding.edLoginUsername.text.toString()
            val password = binding.edLoginPassword.text.toString()
            loginViewModel.login(username,password)
        }
    }
}