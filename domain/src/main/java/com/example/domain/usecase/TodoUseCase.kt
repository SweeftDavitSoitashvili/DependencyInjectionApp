package com.example.domain.usecase

import com.example.domain.GeneralResponse
import com.example.domain.model.TodoDomain
import com.example.domain.repository.TodoRepository

/**
 * Created by Davit Soitashvili on 11.03.22
 **/

class TodoUseCase(private val todoRepository: TodoRepository) {
    suspend operator fun invoke() : GeneralResponse<List<TodoDomain>> {
        return todoRepository.getTodos()
    }
}