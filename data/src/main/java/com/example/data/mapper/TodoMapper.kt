package com.example.data.mapper

import com.example.data.dto.Todo
import com.example.domain.model.TodoDomain

/**
 * Created by Davit Soitashvili on 11.03.22
 **/

class TodoMapper {
    fun mapToTodoDomainList(todos: List<Todo>): List<TodoDomain> {
        val todoDomainList = mutableListOf<TodoDomain>()
        todos.forEach {
            todoDomainList.add(
                TodoDomain(
                    userId = it.userId,
                    id = it.id,
                    title = it.title,
                    completed = it.completed
                )
            )
        }
        return todoDomainList
    }
}