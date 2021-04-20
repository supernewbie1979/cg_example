package com.example.myapplication.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.viewmodel.CgViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class CgViewModelFactoryModule {

    @Binds
    abstract fun provideCgViewModelFactory(cgViewModelFactory: CgViewModelFactory): ViewModelProvider.Factory
}