package com.spitionary.spitionary.view.splash_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.spitionary.spitionary.utils.SharedPreferences
import com.spitionary.spitionary.view.main_menu.MainActivity
import com.spitionary.spitionary.view.onboarding_screen.OnBoardingScreenActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var pre : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        pre = SharedPreferences(this)

        Handler(Looper.getMainLooper()).postDelayed({

            val i: Intent = if (!pre.firstInstall) {
                Intent(this, OnBoardingScreenActivity::class.java)
            } else {
                Intent(this, MainActivity::class.java)
            }
            startActivity(i)
            finish()
        }, 3000)
    }
}