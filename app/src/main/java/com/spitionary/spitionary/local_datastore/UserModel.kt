package com.spitionary.spitionary.local_datastore

data class UserModel(
    val userId : String,
    val username : String,
    val email : String,
    val token : String,
    val isLogin : Boolean,
)