package com.spitionary.spitionary.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.spitionary.spitionary.local_datastore.UserModel
import com.spitionary.spitionary.local_datastore.UserPreferences

class MainViewModel(private val pref : UserPreferences) : ViewModel() {
    fun getUserInMainMenu() : LiveData<UserModel> {
        return pref.getUser().asLiveData()
    }
}