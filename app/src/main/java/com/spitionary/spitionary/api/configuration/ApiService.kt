package com.spitionary.spitionary.api.configuration

import com.spitionary.spitionary.api.api_responses.dictionary.DictionaryResponse
import com.spitionary.spitionary.api.api_responses.login.LoginResponse
import com.spitionary.spitionary.api.api_responses.register.SuccessfulRegisterResponse
import com.spitionary.spitionary.api.api_responses.scan.ScanSpicesResponse
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @FormUrlEncoded
    @POST("register")
    fun registerAccount(
        @Field("username") username : String,
        @Field("email") email : String,
        @Field("password") password : String
    ) : Call<SuccessfulRegisterResponse>

    @FormUrlEncoded
    @POST("login")
    fun loginAccount(
        @Field("email") email: String,
        @Field("password") password: String
    ) : Call<LoginResponse>

    @GET("spices")
    fun getAllSpicesDictionary(
        @Header("Authorization") token : String
    ) : Call<DictionaryResponse>

    @Multipart
    @POST("spices/scan")
    fun scanSpices(
        @Header("Authorization") token: String,
        @Part image : MultipartBody.Part
    ) : Call<ScanSpicesResponse>
}