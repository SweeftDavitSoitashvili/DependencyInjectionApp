package com.example.domain.response_handler


/**
 * Created by Davit Soitashvili on 11.03.22
 **/

sealed class GeneralResponse<RESPONSE> {
    class OnSuccess<RESPONSE>(val response : RESPONSE) : GeneralResponse<RESPONSE>()
    class OnFailure<RESPONSE>(val message : String) : GeneralResponse<RESPONSE>()
}