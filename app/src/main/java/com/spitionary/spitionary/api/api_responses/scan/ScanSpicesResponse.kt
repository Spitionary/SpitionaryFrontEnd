package com.spitionary.spitionary.api.api_responses.scan

import com.google.gson.annotations.SerializedName
import com.spitionary.spitionary.api.api_responses.scan.ScanSpicesApiModel

data class ScanSpicesResponse(

	@field:SerializedName("error")
	val error: Boolean,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("predictionResult")
	val predictionResult: ScanSpicesApiModel
)