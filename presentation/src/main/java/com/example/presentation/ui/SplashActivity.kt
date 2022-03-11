package com.example.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import com.example.base.BaseActivity
import com.example.presentation.databinding.ActivitySplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by Davit Soitashvili on 11.03.22
 **/

class SplashActivity : BaseActivity<ActivitySplashBinding>() {
    override fun provideBinding(layoutInflater: LayoutInflater): ActivitySplashBinding =
        ActivitySplashBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
            delay(2000)
            startActivity(Intent(applicationContext, TodoActivity::class.java))
        }
    }
}