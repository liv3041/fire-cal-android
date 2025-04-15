package com.toonandtools.auth.domain

data class LoginOptions (
    val hasEmail:Boolean,
    val hasPhone:Boolean,
    val hasGoogle:Boolean,
    val hasFacebook:Boolean,
    val hasTwitter:Boolean,
    val hasApple:Boolean
)