package com.thurainx.animationapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thurainx.animationapp.databinding.ActivityNextBinding

class NextActivity : AppCompatActivity() {
    private lateinit var binding : ActivityNextBinding
    companion object {
        fun getIntent(context: Context): Intent {
            val intent = Intent(context, NextActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.nextAppBar).apply {
            title = "Next Activity"
        }

    }
}