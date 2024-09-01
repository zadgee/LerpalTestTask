package com.example.lerpaltesttask.application

import android.app.Application
import com.example.lerpaltesttask.glue.first_screen_feature.firstScreenModule
import com.example.lerpaltesttask.glue.first_screen_feature.firstScreenViewModelModule
import com.example.lerpaltesttask.glue.second_screen_feature.secondScreenModule
import com.example.lerpaltesttask.glue.second_screen_feature.secondScreenViewModelModule
import di.dbModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class LerpalApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(applicationContext)
            modules(
                dbModule, firstScreenModule,
                firstScreenViewModelModule,
                secondScreenModule, secondScreenViewModelModule
            )
        }
    }
}