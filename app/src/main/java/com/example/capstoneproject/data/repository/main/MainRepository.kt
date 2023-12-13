package com.example.capstoneproject.data.repository.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.capstoneproject.data.model.UserPreference
import com.example.capstoneproject.data.remote.main.ApiService
import com.example.capstoneproject.data.repository.auth.UserRepository
import com.example.capstoneproject.data.response.auth.login.LoginResponse
import com.example.capstoneproject.data.response.main.history.HistoryResponse
import com.example.capstoneproject.data.response.main.history.ImagesItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository(private val userPreference: UserPreference, private val apiService: ApiService) {


    private val historyResponse = MutableLiveData<HistoryResponse>()
    suspend fun getSession(): String? {
        return userPreference.getSession()
    }

    fun predict(){

    }
    fun history(): LiveData<List<ImagesItem>>{
        
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