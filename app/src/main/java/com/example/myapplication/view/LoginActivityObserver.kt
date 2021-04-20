package com.example.myapplication.view

interface LoginActivityObserver {
    fun passwordIsEntered(password: String)
    fun passwordIsReentered(password: String)
    fun userNameIsEntered(username: String)

}