package com.example.myapplication.router

import android.app.Application
import android.content.Intent
import com.example.myapplication.view.MainActivity
import javax.inject.Inject

class LoginActivityRouterImpl @Inject constructor(private val application: Application) :
    ILoginActivityRouter {
    override fun goToMainActivity() {
        application.run {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            this.startActivity(intent)
        }

    }
}