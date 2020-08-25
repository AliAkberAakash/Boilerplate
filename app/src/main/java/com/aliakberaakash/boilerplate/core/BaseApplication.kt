package com.aliakberaakash.boilerplate.core

import android.app.Application
import com.aliakberaakash.boilerplate.di.DaggerApplicationComponent
import timber.log.Timber

class BaseApplication : Application() {

    val appComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}