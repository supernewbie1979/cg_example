package com.example.myapplication

import android.app.Application
import com.example.myapplication.di.component.CgComponent
import com.example.myapplication.di.component.DaggerCgComponent

class CgSampleApplication : Application() {
    private lateinit var cgComponent: CgComponent
    override fun onCreate() {
        super.onCreate()
        cgComponent = DaggerCgComponent.builder().applicationContext(this).build()
    }

    fun getCgComponent(): CgComponent {
        return cgComponent
    }
}