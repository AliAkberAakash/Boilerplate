package com.aliakberaakash.boilerplate.core.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.aliakberaakash.boilerplate.utils.BaseViewModelFactory

import java.lang.reflect.ParameterizedType


/**
 * This class is a boilerplate for setting up an Activity
 * All Activities in this project should extend this class
 * @author Ali Akber
 */


abstract class BaseActivity<ViewModel: BaseViewModel, Binding: ViewDataBinding> : AppCompatActivity(){

    lateinit var viewModel: ViewModel
    lateinit var binding: Binding

    abstract fun getLayoutId(): Int

    abstract fun getViewModelFactory() : BaseViewModelFactory

    abstract fun setVariables(binding: Binding)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, getViewModelFactory()).get(getViewModelClass())
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        binding.lifecycleOwner = this
        lifecycle.addObserver(viewModel)
        setVariables(binding)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
    }

    private fun getViewModelClass(): Class<ViewModel> {
        val type =
            (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        return type as Class<ViewModel>
    }

    fun makeShortToast(message : String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}