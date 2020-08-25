package com.aliakberaakash.boilerplate.ui.features.main

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.aliakberaakash.boilerplate.R
import com.aliakberaakash.boilerplate.core.BaseApplication
import com.aliakberaakash.boilerplate.core.ui.BaseActivity
import com.aliakberaakash.boilerplate.core.ui.BaseViewModel
import com.aliakberaakash.boilerplate.data.models.InjectableItem
import com.aliakberaakash.boilerplate.utils.BaseViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity<BaseViewModel, ViewDataBinding>() {

    @Inject
    lateinit var injectableItem: InjectableItem

    override fun getLayoutId() =
        R.layout.activity_main

    override fun setVariables(binding: ViewDataBinding) {}

    override fun getViewModelFactory() = BaseViewModelFactory()

    override fun onCreate(savedInstanceState: Bundle?) {

        (application as BaseApplication).appComponent.inject(this)

        super.onCreate(savedInstanceState)

        text.setOnClickListener {
            injectableItem.makeToast()
        }

    }

}