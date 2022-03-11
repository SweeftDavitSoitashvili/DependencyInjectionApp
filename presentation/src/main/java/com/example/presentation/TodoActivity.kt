package com.example.presentation

import android.view.LayoutInflater
import com.example.base.BaseActivity
import com.example.presentation.databinding.ActivityTodoBinding

class TodoActivity : BaseActivity<ActivityTodoBinding>() {

    override fun provideBinding(layoutInflater: LayoutInflater): ActivityTodoBinding =
        ActivityTodoBinding.inflate(layoutInflater)
}


