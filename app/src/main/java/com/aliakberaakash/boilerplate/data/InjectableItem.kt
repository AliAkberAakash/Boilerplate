package com.aliakberaakash.boilerplate.data

import android.content.Context
import javax.inject.Inject

class InjectableItem @Inject constructor(private val context: Context) {

    @Inject
    lateinit var anotherInjectableItem : AnotherInjectableItem

    fun makeToast(){
        anotherInjectableItem.makeToast(context)
    }
}