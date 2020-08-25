package com.aliakberaakash.boilerplate.data.models

import android.content.Context
import com.aliakberaakash.boilerplate.data.models.AnotherInjectableItem
import javax.inject.Inject

class InjectableItem @Inject constructor(private val context: Context) {

    @Inject
    lateinit var anotherInjectableItem : AnotherInjectableItem

    fun makeToast(){
        anotherInjectableItem.makeToast(context)
    }
}