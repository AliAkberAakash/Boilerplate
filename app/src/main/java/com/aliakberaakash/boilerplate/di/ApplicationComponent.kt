package com.aliakberaakash.boilerplate.di

import android.content.Context
import com.aliakberaakash.boilerplate.ui.features.main.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent {

    fun inject(activity : MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context) : ApplicationComponent
    }
}