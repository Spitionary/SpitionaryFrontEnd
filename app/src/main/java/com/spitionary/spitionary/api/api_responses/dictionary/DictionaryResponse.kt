package com.spitionary.spitionary.api.api_responses.dictionary

import com.google.gson.annotations.SerializedName
import com.spitionary.spitionary.api.api_responses.dictionary.DictionaryApiModel

data class DictionaryResponse(

	@field:SerializedName("error")
	val error: Boolean,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("spicesResult")
	val spicesResult: ArrayList<DictionaryApiModel>
)