package com.example.data.apiservice

import com.example.data.dto.Todo
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Davit Soitashvili on 11.03.22
 **/

interface TodoApiService {
    @GET("todos")
    suspend fun getTodos() : Response<List<Todo>>
}