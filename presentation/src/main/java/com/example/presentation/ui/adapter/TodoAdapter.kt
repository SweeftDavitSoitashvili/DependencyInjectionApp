package com.example.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.TodoDomain
import com.example.presentation.databinding.TodoRecyclerItemBinding

/**
 * Created by Davit Soitashvili on 11.03.22
 **/

class TodoAdapter(private val todos: List<TodoDomain>) :
    RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TodoViewHolder(
        TodoRecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.onBindTodo(todos[position])
    }

    override fun getItemCount() = todos.size

    class TodoViewHolder(private val binding: TodoRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBindTodo(todoDomain: TodoDomain) {
            with(binding) {
                todoTitleView.text = todoDomain.title
                todoIsCompletedView.text =
                    if (todoDomain.completed) "COMPLETED" else "NOT COMPLETED"
            }
        }
    }
}