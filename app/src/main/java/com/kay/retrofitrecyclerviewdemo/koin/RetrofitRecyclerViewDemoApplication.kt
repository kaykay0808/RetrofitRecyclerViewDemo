package com.kay.retrofitrecyclerviewdemo.koin

import android.app.Application
import com.kay.retrofitrecyclerviewdemo.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RetrofitRecyclerViewDemoApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@RetrofitRecyclerViewDemoApplication)
            modules(appModule)
        }
    }
}