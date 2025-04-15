package com.toonandtools.auth.domain

class GetLoginOptionsUseCase(private val repository: LoginOptionsRepository) {
    suspend operator fun invoke(userId: String): LoginOptions {
        return repository.getLoginOptions(userId)
    }

}