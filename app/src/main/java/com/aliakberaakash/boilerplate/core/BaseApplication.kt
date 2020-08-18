package com.aliakberaakash.boilerplate.core

import android.app.Application
import android.content.Context

class BaseApplication : Application() {

    val context: Context = this.applicationContext

}