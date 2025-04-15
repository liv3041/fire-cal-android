package com.toonandtools.auth.domain

interface LoginOptionsRepository {
    suspend fun getLoginOptions(userId:String):LoginOptions
}