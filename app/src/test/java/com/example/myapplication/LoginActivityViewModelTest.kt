package com.example.myapplication

import android.app.Application
import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.myapplication.router.ILoginActivityRouter
import com.example.myapplication.service.IMyService
import com.example.myapplication.viewmodel.LoginActivityViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.internal.matchers.Any

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class LoginActivityViewModelTest {

    /**
     * this is to avoid:
     * java.lang.NullPointerException
        at androidx.arch.core.executor.DefaultTaskExecutor.isMainThread(DefaultTaskExecutor.java:77)
        at androidx.arch.core.executor.ArchTaskExecutor.isMainThread(ArchTaskExecutor.java:116)
        at androidx.lifecycle.LiveData.assertMainThread(LiveData.java:442)
        at androidx.lifecycle.LiveData.setValue(LiveData.java:286)
        at androidx.lifecycle.MutableLiveData.setValue(MutableLiveData.java:33)
     */
    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var serviceMock: IMyService

    lateinit var viewModel: LoginActivityViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = LoginActivityViewModel(Mockito.mock(Application::class.java),
                                           Mockito.mock((ILoginActivityRouter::class.java)),
                                           serviceMock)
    }
    @Test
    fun addition_isCorrect() {
        Mockito.`when`(serviceMock.getUserDetail(Mockito.anyString())).thenReturn("fake")
        viewModel.enterUsername("username")
    }

    @Test
    fun testSetPassword() {
        viewModel.setPassword("123")
        viewModel.reenterPassword("123")
    }
}