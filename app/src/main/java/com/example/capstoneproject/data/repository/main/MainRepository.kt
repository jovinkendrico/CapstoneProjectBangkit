package com.example.capstoneproject.data.repository.main

import com.example.capstoneproject.data.model.UserPreference
import com.example.capstoneproject.data.remote.main.ApiService
import com.example.capstoneproject.data.repository.auth.UserRepository
import kotlinx.coroutines.flow.Flow

class MainRepository(private val userPreference: UserPreference, private val apiService: ApiService) {


    suspend fun getSession(): String? {
        return userPreference.getSession()
    }

    fun predict(){

    }
    fun history(){

    }
    companion object {
        const val TAG="UserRepository"
        @Volatile
        private var instance: MainRepository? = null
        fun getInstance(
            userPreference: UserPreference,
            apiService: ApiService
        ): MainRepository =
            instance ?: synchronized(this) {
                instance ?: MainRepository(userPreference,apiService)
            }.also { instance = it }
    }
}