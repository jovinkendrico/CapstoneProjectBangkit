package com.example.capstoneproject.ui.auth.register

import androidx.lifecycle.ViewModel
import com.example.capstoneproject.data.repository.auth.UserRepository

class RegisterViewModel(private val repository: UserRepository):ViewModel() {

    companion object{
        const val TAG="RegisterViewModel"
    }

    fun login(name: String,username: String, password: String){
        repository.register(name,username,password)
    }
}