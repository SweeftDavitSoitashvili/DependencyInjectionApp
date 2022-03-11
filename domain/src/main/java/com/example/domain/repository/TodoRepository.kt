package com.example.domain.repository

import com.example.domain.GeneralResponse
import com.example.domain.model.TodoDomain

/**
 * Created by Davit Soitashvili on 11.03.22
 **/

interface TodoRepository {
    suspend fun getTodos(): GeneralResponse<List<TodoDomain>>
}