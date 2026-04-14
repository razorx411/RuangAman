package com.ubermensch.ruangamanv10

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
class AuthViewModel {
    private val _loginResult = MutableLiveData<Result>()
    val loginResult: LiveData<Result> = _loginResult

    fun login(email: String, pass: String) {
        // Logika login kamu nanti di sini
    }
}

// Sealed class untuk handle status Success/Error
sealed class Result {
    object Success : Result()
    data class Error(val message: String) : Result()

}