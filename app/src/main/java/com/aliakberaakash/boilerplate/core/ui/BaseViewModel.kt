package com.aliakberaakash.boilerplate.core.ui

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber


open class BaseViewModel : ViewModel(), IViewModel {

    val loader = MutableLiveData<Boolean>()

    override fun onAny(owner: LifecycleOwner?, event: Lifecycle.Event?) {
        Timber.d("${event?.name}")
    }

    override fun onCreate() {

    }

    override fun onDestroy() {

    }

    override fun onStart() {

    }

    override fun onStop() {

    }

    override fun onResume() {

    }

    override fun onPause() {

    }
}