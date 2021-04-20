package com.example.myapplication.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.service.IMyService
import com.example.myapplication.service.MyServiceImpl
import com.example.myapplication.viewmodel.CgViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class MyServiceModule {

    @Binds
    abstract fun provideService(service: MyServiceImpl): IMyService
}