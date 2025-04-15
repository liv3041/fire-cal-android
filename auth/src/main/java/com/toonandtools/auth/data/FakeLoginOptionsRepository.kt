package com.toonandtools.auth.data

import com.toonandtools.auth.domain.LoginOptions
import com.toonandtools.auth.domain.LoginOptionsRepository
import kotlinx.coroutines.delay

class FakeLoginOptionsRepository:LoginOptionsRepository {
    override suspend fun getLoginOptions(userId: String): LoginOptions {
        delay(1000)
        return when(userId){
            "user_email"->LoginOptions(true,false,false,false,false,false)
            "use_phone"->LoginOptions(false,true,false,false,false,false)
            "use_both"->LoginOptions(true,true,false,false,false,false)
            else->(LoginOptions(false,false,false,false,false,false))
        }
    }

}