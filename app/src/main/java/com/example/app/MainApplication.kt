package com.example.app

import android.app.Application
import com.example.data.Retrofit
import com.example.data.apiservice.TodoApiService
import com.example.data.datasource.TodoDataSource
import com.example.data.datasource.TodoDataSourceImpl
import com.example.data.mapper.TodoMapper
import com.example.data.repository.TodoRepositoryImpl
import com.example.domain.repository.TodoRepository
import com.example.domain.usecase.TodoUseCase
import com.example.presentation.vm.TodoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

/**
 * Created by Davit Soitashvili on 11.03.22
 **/

class MainApplication : Application() {
    companion object {
        private var mainApplication: MainApplication? = null

        fun getMainApplication() = mainApplication
    }

    override fun onCreate() {
        super.onCreate()
        if (mainApplication == null) {
            mainApplication = this
        }
        initKoinContainer()
    }

    private fun initKoinContainer() {
        val koinApplication = startKoin {}
        koinApplication.modules(
            getRandomModule()
        )
    }

    private fun getRandomModule() = module {
        single<TodoApiService> { Retrofit.getRetrofit().create(TodoApiService::class.java) }
        single<TodoDataSource> { TodoDataSourceImpl(get()) }
        single { TodoMapper() }
        single<TodoRepository> { TodoRepositoryImpl(get(), get()) }
        factory { TodoUseCase(get()) }
        viewModel { TodoViewModel(get()) }
    }
}