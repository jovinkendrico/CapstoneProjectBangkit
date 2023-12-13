package com.example.capstoneproject.data.repository.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.capstoneproject.data.model.UserPreference
import com.example.capstoneproject.data.remote.main.ApiService
import com.example.capstoneproject.data.response.main.history.HistoryResponse

import com.example.capstoneproject.data.response.main.history.ImagesItem
import kotlinx.coroutines.flow.Flow
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository(private val userPreference: UserPreference, private val apiService: ApiService) {


    private val _listImagesItem = MutableLiveData<ArrayList<ImagesItem>>()
    fun getSession(): Flow<String> {
        return userPreference.getSession()
    }

    fun predict(){

    }
    fun history(username: String): LiveData<ArrayList<ImagesItem>>{
        
        val client = apiService.history(username)

        client.enqueue(object :Callback<HistoryResponse>{
            override fun onResponse(
                call: Call<HistoryResponse>,
                response: Response<HistoryResponse>
            ) {
                val data = response.body()
                if (response.isSuccessful){
                    if (data != null) {
                        _listImagesItem.value = ArrayList(data.images)
                    }
                }
            }
            override fun onFailure(call: Call<HistoryResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })
        return _listImagesItem
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