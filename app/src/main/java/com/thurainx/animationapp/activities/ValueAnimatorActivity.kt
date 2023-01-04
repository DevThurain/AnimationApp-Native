package com.thurainx.animationapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thurainx.animationapp.R

class ValueAnimatorActivity : AppCompatActivity() {
    companion object {
        fun getIntent(context: Context): Intent {
            val intent = Intent(context, ValueAnimatorActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_value_animator)

    }
}