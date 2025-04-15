package com.toonandtools.auth.presentation

import AuthViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.toonandtools.auth.data.FakeLoginOptionsRepository
import com.toonandtools.auth.domain.GetLoginOptionsUseCase

class AuthViewModelFactory:ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val repository = FakeLoginOptionsRepository()
        val useCase = GetLoginOptionsUseCase(repository)
        return AuthViewModel(useCase) as T

    }
}