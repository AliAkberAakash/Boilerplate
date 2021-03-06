package com.aliakberaakash.boilerplate.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aliakberaakash.boilerplate.core.ui.BaseViewModel

/**
 * This class creates an instance for ViewModel classes that
 * have been extended from BaseViewModel class
 * @author Ali Akber
 */
class BaseViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BaseViewModel::class.java)) {
            return BaseViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}