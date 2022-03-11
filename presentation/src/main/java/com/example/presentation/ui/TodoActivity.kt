package com.example.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.base.BaseActivity
import com.example.domain.model.TodoDomain
import com.example.presentation.databinding.ActivityTodoBinding
import com.example.presentation.ui.adapter.TodoAdapter
import com.example.presentation.vm.TodoViewModel
import org.koin.android.ext.android.inject

class TodoActivity : BaseActivity<ActivityTodoBinding>() {

    private val todoViewModel: TodoViewModel by inject()

    override fun provideBinding(layoutInflater: LayoutInflater): ActivityTodoBinding =
        ActivityTodoBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        todoViewModel.makeTodoApiCall()

        todoViewModel.todos.observe(this) {
            initTodoAdapter(it)
        }

        todoViewModel.errorMessage.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
    }

    private fun initTodoAdapter(todos: List<TodoDomain>) {
        binding.todosRecyclerView.adapter = TodoAdapter(todos)
        binding.todosRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}


