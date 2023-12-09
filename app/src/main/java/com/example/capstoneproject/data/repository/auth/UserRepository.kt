package com.example.capstoneproject.data.repository.auth

import com.example.capstoneproject.data.model.auth.login.LoginModel
import com.example.capstoneproject.data.model.auth.register.RegisterModel
import com.example.capstoneproject.data.remote.login.ApiService
import com.example.capstoneproject.data.response.auth.login.LoginResponse
import com.example.capstoneproject.data.response.auth.register.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(private val apiService: ApiService) {

    fun login(username: String, password: String){
        val loginModel: LoginModel = LoginModel(username,password)
        apiService.login(loginModel).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun register(name: String, username: String, password: String){
        val registerModel: RegisterModel = RegisterModel(name,username,password)
        apiService.register(registerModel).enqueue(object : Callback<RegisterResponse>{
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
    companion object {
        @Volatile
        private var instance: UserRepository? = null
        fun getInstance(
            apiService: ApiService
        ): UserRepository =
            instance ?: synchronized(this) {
                instance ?: UserRepository(apiService)
            }.also { instance = it }
    }
}