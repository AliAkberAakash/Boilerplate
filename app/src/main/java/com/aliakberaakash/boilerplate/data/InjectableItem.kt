package com.aliakberaakash.boilerplate.data

import android.content.Context
import android.widget.Toast
import javax.inject.Inject

class InjectableItem @Inject constructor(val context: Context) {

    fun makeToast() {
        Toast.makeText(context, "toast from InjectableItem", Toast.LENGTH_SHORT).show()
    }
}