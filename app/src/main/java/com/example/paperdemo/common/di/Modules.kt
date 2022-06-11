package com.example.paperdemo.common.di

import com.example.paperdemo.home.viewModel.HomeViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var databaseModule = module {
    single { getDatabase(androidApplication()) }
    single { getHomeDao(get()) }
}

var repositoryModule = module {
    single { getHomeRepository(get()) }
}

var viewModelModule = module {
    viewModel { HomeViewModel(get()) }
}

