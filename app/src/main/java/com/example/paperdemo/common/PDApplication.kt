package com.example.paperdemo.common

import android.app.Application
import com.example.paperdemo.common.di.databaseModule
import com.example.paperdemo.common.di.repositoryModule
import com.example.paperdemo.common.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PDApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(applicationContext)
            koin.loadModules(
                listOf(
                    databaseModule,
                    viewModelModule,
                    repositoryModule
                )
            )
        }
    }
}