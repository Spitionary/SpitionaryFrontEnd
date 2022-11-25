package com.spitionary.spitionary.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.spitionary.spitionary.local_datastore.UserModel
import com.spitionary.spitionary.local_datastore.UserPreferences
import kotlinx.coroutines.launch

class ProfileViewModel(private val pref : UserPreferences) : ViewModel() {
    fun getUserInProfile() : LiveData<UserModel> {
        return pref.getUser().asLiveData()
    }

    fun logoutInProfile() {
        viewModelScope.launch {
            pref.logout()
        }
    }
}