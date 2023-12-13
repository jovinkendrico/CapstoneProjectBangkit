package com.example.capstoneproject.ui.main

import androidx.lifecycle.ViewModel
import com.example.capstoneproject.data.repository.auth.UserRepository
import com.example.capstoneproject.data.repository.main.MainRepository

class MainViewModel(private val repository: MainRepository): ViewModel() {

    companion object{
        const val TAG ="MainViewModel"
    }

}