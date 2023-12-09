package com.example.capstoneproject.di

import android.content.Context
import com.example.capstoneproject.data.remote.login.ApiConfig
import com.example.capstoneproject.data.repository.auth.UserRepository
import kotlinx.coroutines.runBlocking

object Injection {
    fun provideUserRepository(context: Context): UserRepository {
        val apiService = ApiConfig.getApiService()
        return UserRepository.getInstance(apiService)
    }
}