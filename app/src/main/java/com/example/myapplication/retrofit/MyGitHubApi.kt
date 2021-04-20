package com.example.myapplication.retrofit

import com.example.myapplication.retrofit.model.UserRaw
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MyGitHubApi {
    @GET("users/{username}")
    fun getUserDetail(@Path("username") username: String): Call<UserRaw>
}