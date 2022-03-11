package com.example.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Davit Soitashvili on 11.03.22
 **/

object Retrofit {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com?"
    fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}