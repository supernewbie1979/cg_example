package com.example.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.router.ILoginActivityRouter
import com.example.myapplication.service.IMyService
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class CgViewModelFactory @Inject constructor(private val context: Application,
                                             private val router: ILoginActivityRouter,
                                             private val service: IMyService/*,
                                             private val creators: Map<Class<out ViewModel>,
                                    @JvmSuppressWildcards Provider<ViewModel>>*/) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginActivityViewModel(context, router, service) as T
        /*var creator: Provider<out ViewModel>? = creators[modelClass]
        if (creator == null) {
            for ((key, value) in creators) {
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }
        if (creator == null) {
            throw IllegalArgumentException("unknown model class $modelClass")
        }
        try {
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }*/
    }

}