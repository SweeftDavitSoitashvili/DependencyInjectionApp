package com.example.data.datasource

import com.example.data.dto.Todo
import com.example.domain.response_handler.GeneralResponse

/**
 * Created by Davit Soitashvili on 11.03.22
 **/

interface TodoDataSource {
    suspend fun getTodos() : GeneralResponse<List<Todo>>
}