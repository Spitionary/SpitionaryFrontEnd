package com.spitionary.spitionary.api.api_responses.login

import com.google.gson.annotations.SerializedName
import com.spitionary.spitionary.api.api_responses.login.LoginApiModel

data class LoginResponse(

    @field:SerializedName("error")
	val error: Boolean,

    @field:SerializedName("message")
	val message: String,

    @field:SerializedName("loginResult")
	val loginResult: LoginApiModel,
)
