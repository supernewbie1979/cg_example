package com.example.myapplication.viewmodel

import android.app.Application
import android.telecom.InCallService
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.router.ILoginActivityRouter
import com.example.myapplication.service.IMyService
import com.example.myapplication.service.MyServiceImpl
import javax.inject.Inject

class LoginActivityViewModel(private val context: Application,
                             private val router: ILoginActivityRouter,
                             private val service: IMyService) : AndroidViewModel(context) {
    private val matchedMutableLiveData: MutableLiveData<Boolean> = MutableLiveData()
    private val fragIndexMutableLiveData: MutableLiveData<Int> = MutableLiveData()

    private lateinit var password: String

    companion object {
        private const val SECOND_FRAGMENT = 1
        private const val THIRD_FRAGMENT = 2
    }

    fun setPassword(password: String) {
        this.password = password
        fragIndexMutableLiveData.value = SECOND_FRAGMENT
    }

    fun reenterPassword(password: String) {
        if (this.password == password) {
            fragIndexMutableLiveData.value = THIRD_FRAGMENT
        } else {
            matchedMutableLiveData.value = false
        }
    }

    // TODO: TO BE CONTINUED
    fun enterUsername(username: String) {
        service.getUserDetail(username)
    }

    fun getMatchedLiveData(): LiveData<Boolean> {
        return matchedMutableLiveData
    }

    fun getFragIndexLiveData(): LiveData<Int> {
        return fragIndexMutableLiveData
    }

    override fun onCleared() {
        super.onCleared()
    }


}