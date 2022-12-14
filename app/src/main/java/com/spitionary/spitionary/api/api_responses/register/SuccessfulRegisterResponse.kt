package com.spitionary.spitionary.api.api_responses.register

import com.google.gson.annotations.SerializedName

data class SuccessfulRegisterResponse(

	@field:SerializedName("error")
	val error: Boolean,

	@field:SerializedName("message")
	val message: String
)
