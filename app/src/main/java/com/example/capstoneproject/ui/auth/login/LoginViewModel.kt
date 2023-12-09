package com.example.capstoneproject.ui.auth.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.capstoneproject.data.repository.auth.UserRepository
import com.example.capstoneproject.data.response.auth.login.LoginResponse

class LoginViewModel(private val repository: UserRepository):ViewModel() {

    companion object{
        const val TAG="LoginViewModel"
    }

    fun login(username: String, password: String){
        repository.login(username,password)
    }
}