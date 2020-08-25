package com.aliakberaakash.boilerplate.data

import android.content.Context
import android.widget.Toast
import javax.inject.Inject

class AnotherInjectableItem @Inject constructor(){
    fun makeToast(context: Context) {
        Toast.makeText(context, "This toast is by AnotherInjectable Item", Toast.LENGTH_SHORT).show()
    }
}