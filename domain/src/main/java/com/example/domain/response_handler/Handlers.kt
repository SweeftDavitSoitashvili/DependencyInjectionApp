package com.example.domain.response_handler

import retrofit2.Response

/**
 * Created by Davit Soitashvili on 11.03.22
 **/

object Handlers {
    fun <DATA> responseHandler(response: Response<DATA>): GeneralResponse<DATA> {
        return if (response.isSuccessful) {
            GeneralResponse.OnSuccess(response.body()!!)
        } else {
            GeneralResponse.OnFailure(response.message())
        }
    }
}