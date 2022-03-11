package com.example.presentation.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.GeneralResponse
import com.example.domain.model.TodoDomain
import com.example.domain.usecase.TodoUseCase
import kotlinx.coroutines.launch

/**
 * Created by Davit Soitashvili on 11.03.22
 **/

class TodoViewModel(private val todoUseCase : TodoUseCase) : ViewModel() {
    private val _todos : MutableLiveData<List<TodoDomain>> = MutableLiveData()
    private val _errorMessage : MutableLiveData<String> = MutableLiveData()
    val todos : LiveData<List<TodoDomain>> = _todos
    val errorMessage : LiveData<String> = _errorMessage

    fun makeTodoApiCall() {
        viewModelScope.launch {
            when (val response = todoUseCase.invoke()) {
                is GeneralResponse.OnSuccess -> _todos.value = response.response
                is GeneralResponse.OnFailure -> _errorMessage.value = response.message
            }
        }
    }
}