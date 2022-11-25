package com.spitionary.spitionary.view.main_menu

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.spitionary.spitionary.databinding.ActivityMainBinding
import com.spitionary.spitionary.local_datastore.UserModel
import com.spitionary.spitionary.local_datastore.UserPreferences
import com.spitionary.spitionary.utils.ViewModelFactory
import com.spitionary.spitionary.view.article.ArticleActivity
import com.spitionary.spitionary.view.dictionary.DictionaryActivity
import com.spitionary.spitionary.view.profile.ProfileActivity
import com.spitionary.spitionary.view.welcome_screen.WelcomeActivity
import com.spitionary.spitionary.view_model.MainViewModel

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding : ActivityMainBinding
    private lateinit var user : UserModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        setupViewModel()
        setupMainMenuAction()

    }

    private fun setupMainMenuAction() {

        binding.menuDictionary.setOnClickListener {
            shareTokenAndMoveToDictionaryActivity()
        }

        binding.menuArticle.setOnClickListener {
            moveToArticleActivity()
        }

        binding.menuProfile.setOnClickListener {
            shareTokenAndMoveToProfileActivity()
        }
    }

    private fun shareTokenAndMoveToProfileActivity() {
        mainViewModel.getUserInMainMenu().observe(this) { user ->
            this.user = user
            Log.d("Move Activity","Your Token : ${user.token}")

            if (this.user.isLogin) {
                val intent = Intent(this, ProfileActivity::class.java)
                intent.let {
                    it.putExtra(ProfileActivity.EXTRA_TOKEN_PROFILE, user.token)
                    startActivity(it)
                }
            }
        }
    }

    private fun moveToArticleActivity() {
        startActivity(Intent(this, ArticleActivity::class.java))
    }

    private fun shareTokenAndMoveToDictionaryActivity() {
        mainViewModel.getUserInMainMenu().observe(this) { user ->
            this.user = user
            Log.d("Move Activity","Your Token : ${user.token}")

            if (this.user.isLogin) {
                val intent = Intent(this, DictionaryActivity::class.java)
                intent.let {
                    it.putExtra(DictionaryActivity.EXTRA_TOKEN_DICTIONARY, user.token)
                    startActivity(it)
                }
            }
        }
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProvider(
            this,
            ViewModelFactory(UserPreferences.getInstance(dataStore))
        )[MainViewModel::class.java]

        mainViewModel.getUserInMainMenu().observe(this) { user ->
            if (!user.isLogin) {
                startActivity(Intent(this, WelcomeActivity::class.java))
                finish()
            }
        }
    }

    companion object {
        const val EXTRA_MAIN_MENU = "extra_main_menu"
    }
}