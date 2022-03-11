package com.example.data.datasource

import com.example.data.apiservice.TodoApiService
import com.example.data.dto.Todo
import com.example.domain.response_handler.GeneralResponse
import com.example.domain.response_handler.Handlers

/**
 * Created by Davit Soitashvili on 11.03.22
 **/

class TodoDataSourceImpl(private val todoApiService: TodoApiService) : TodoDataSource {
    override suspend fun getTodos(): GeneralResponse<List<Todo>> = Handlers.responseHandler(todoApiService.getTodos())
}