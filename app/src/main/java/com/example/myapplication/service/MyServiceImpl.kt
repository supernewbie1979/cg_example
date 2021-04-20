package com.example.myapplication.service

import android.util.Log
import com.example.myapplication.retrofit.MyGitHubApi
import com.example.myapplication.retrofit.model.UserRaw
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


class MyServiceImpl @Inject constructor() : IMyService {
    companion object {
        private const val TAG = "MyServiceImpl"
        private const val BASE_URL = "https://api.github.com/"
    }

    override fun getUserDetail(username: String) {

        val httpClient = OkHttpClient.Builder()

        httpClient.addInterceptor { chain ->
            val request: Request =
                chain.request().newBuilder().addHeader("Content-Type", "application/json").build()
            chain.proceed(request)
        }
        val retrofit = Retrofit.Builder()
                               .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            //.addConverterFactory(ScalarsConverterFactory.create())
            .build()
        val getUserDetailApi = retrofit.create(MyGitHubApi::class.java)
        val call = getUserDetailApi.getUserDetail(username)
        call.enqueue(object : Callback<UserRaw> {
            override fun onFailure(call: Call<UserRaw>?, t: Throwable?) {
                Log.d(TAG, "getUserDetail: " + t?.message)
            }

            override fun onResponse(call: Call<UserRaw>?, response: Response<UserRaw>?) {
                Log.d(TAG, "getUserDetail: " + response?.body().toString())
            }

        })

    }


}