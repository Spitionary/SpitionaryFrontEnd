package com.spitionary.spitionary.view.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import com.spitionary.spitionary.R
import com.spitionary.spitionary.databinding.ActivityAboutBinding
import com.spitionary.spitionary.view.profile.ProfileActivity

class AboutActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.backIcon.setOnClickListener {
            onBackPressed()
        }

        binding.cvSpitionaryDefinition.setOnClickListener {
            if (binding.descSpitionary.visibility == View.GONE) {
                TransitionManager.beginDelayedTransition(binding.cvSpitionaryDefinition, AutoTransition())
                binding.descSpitionary.visibility = View.VISIBLE
                binding.downArrow1.background = AppCompatResources.getDrawable(this, R.drawable.ic_up_arrow)
            } else {
                TransitionManager.beginDelayedTransition(binding.cvSpitionaryDefinition, AutoTransition())
                binding.descSpitionary.visibility = View.GONE
                binding.downArrow1.background = AppCompatResources.getDrawable(this, R.drawable.ic_down_arrow)
            }
        }

//        binding.cvAppDeveloper.setOnClickListener {
//            if (binding.descAppDev.visibility == View.GONE) {
//                TransitionManager.beginDelayedTransition(binding.cvAppDeveloper, AutoTransition())
//                binding.descAppDev.visibility = View.VISIBLE
//                binding.downArrow2.background = AppCompatResources.getDrawable(this, R.drawable.ic_up_arrow)
//            } else {
//                TransitionManager.beginDelayedTransition(binding.cvAppDeveloper, AutoTransition())
//                binding.descAppDev.visibility = View.GONE
//                binding.downArrow2.background = AppCompatResources.getDrawable(this, R.drawable.ic_down_arrow)
//            }
//        }
//
//        binding.cvResources.setOnClickListener {
//            if (binding.descResources.visibility == View.GONE) {
//                TransitionManager.beginDelayedTransition(binding.cvResources, AutoTransition())
//                binding.descResources.visibility = View.VISIBLE
//                binding.downArrow3.background = AppCompatResources.getDrawable(this, R.drawable.ic_up_arrow)
//            } else {
//                TransitionManager.beginDelayedTransition(binding.cvResources, AutoTransition())
//                binding.descResources.visibility = View.GONE
//                binding.downArrow3.background = AppCompatResources.getDrawable(this, R.drawable.ic_down_arrow)
//            }
//        }
//
//        binding.cvContactUs.setOnClickListener {
//            if (binding.descContactUs.visibility == View.GONE) {
//                TransitionManager.beginDelayedTransition(binding.cvContactUs, AutoTransition())
//                binding.descContactUs.visibility = View.VISIBLE
//                binding.downArrow4.background = AppCompatResources.getDrawable(this, R.drawable.ic_up_arrow)
//            } else {
//                TransitionManager.beginDelayedTransition(binding.cvContactUs, AutoTransition())
//                binding.descContactUs.visibility = View.GONE
//                binding.downArrow4.background = AppCompatResources.getDrawable(this, R.drawable.ic_down_arrow)
//            }
//        }
//
//        binding.cvAppVersion.setOnClickListener {
//            if (binding.descAppVersion.visibility == View.GONE) {
//                TransitionManager.beginDelayedTransition(binding.cvAppVersion, AutoTransition())
//                binding.descAppVersion.visibility = View.VISIBLE
//                binding.downArrow5.background = AppCompatResources.getDrawable(this, R.drawable.ic_up_arrow)
//            } else {
//                TransitionManager.beginDelayedTransition(binding.cvAppVersion, AutoTransition())
//                binding.descAppVersion.visibility = View.GONE
//                binding.downArrow5.background = AppCompatResources.getDrawable(this, R.drawable.ic_down_arrow)
//            }
//        }
    }

    override fun onBackPressed() {
        val i = Intent(this, ProfileActivity::class.java)
        i.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(i)
        finish()
    }
}