package com.spitionary.spitionary.api.api_responses.login

import com.google.gson.annotations.SerializedName

data class LoginApiModel (

    @field:SerializedName("userId")
    val userId: String,

    @field:SerializedName("username")
    val username: String,

    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("token")
    val token: String

)