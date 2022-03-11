package com.example.data.repository

import com.example.data.datasource.TodoDataSource
import com.example.data.dto.Todo
import com.example.data.mapper.TodoMapper
import com.example.domain.model.TodoDomain
import com.example.domain.repository.TodoRepository
import com.example.domain.response_handler.GeneralResponse

/**
 * Created by Davit Soitashvili on 11.03.22
 **/

class TodoRepositoryImpl(
    private val todoDataSource: TodoDataSource,
    private val todoMapper: TodoMapper
) : TodoRepository {
    override suspend fun getTodos(): GeneralResponse<List<TodoDomain>> {
        return when (val response = todoDataSource.getTodos()) {
            is GeneralResponse.OnSuccess<List<Todo>> -> GeneralResponse.OnSuccess(
                response = todoMapper.mapToTodoDomainList(
                    response.response
                )
            )
            is GeneralResponse.OnFailure -> GeneralResponse.OnFailure(message = response.message)
        }
    }
}