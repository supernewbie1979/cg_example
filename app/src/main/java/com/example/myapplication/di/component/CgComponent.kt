package com.example.myapplication.di.component

import android.app.Application
import com.example.myapplication.di.module.CgViewModelFactoryModule
import com.example.myapplication.di.module.LoginActivityRounterModule
import com.example.myapplication.di.module.MyServiceModule
import com.example.myapplication.view.LoginActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Component (modules = [CgViewModelFactoryModule::class,
                        LoginActivityRounterModule::class,
                        MyServiceModule::class])
@Singleton
interface CgComponent {

    fun inject(loginActivity: LoginActivity)

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun applicationContext(context: Application): Builder
        fun build(): CgComponent
    }
}