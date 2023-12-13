package com.example.capstoneproject.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstoneproject.data.repository.main.MainRepository
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: MainRepository): ViewModel() {

    fun logout(){
        viewModelScope.launch {
            repository.logout()
        }
    }
}