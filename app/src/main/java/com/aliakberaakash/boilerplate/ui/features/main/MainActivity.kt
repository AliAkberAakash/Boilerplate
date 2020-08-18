package com.aliakberaakash.boilerplate.ui.features.main

import androidx.databinding.ViewDataBinding
import com.aliakberaakash.boilerplate.R
import com.aliakberaakash.boilerplate.core.ui.BaseActivity
import com.aliakberaakash.boilerplate.core.ui.BaseViewModel
import com.aliakberaakash.boilerplate.utils.BaseViewModelFactory

class MainActivity : BaseActivity<BaseViewModel, ViewDataBinding>() {

    override fun getLayoutId() =
        R.layout.activity_main

    override fun setVariables(binding: ViewDataBinding) {}

    override fun getViewModelFactory() = BaseViewModelFactory()

}