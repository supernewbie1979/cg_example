package com.example.myapplication.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.router.ILoginActivityRouter
import com.example.myapplication.router.LoginActivityRouterImpl
import com.example.myapplication.viewmodel.CgViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class LoginActivityRounterModule {

    @Binds
    abstract fun provideRouter(router: LoginActivityRouterImpl): ILoginActivityRouter
}