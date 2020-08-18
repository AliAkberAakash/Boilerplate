package com.aliakberaakash.boilerplate.core

import android.app.Application
import android.content.Context
import timber.log.Timber

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}