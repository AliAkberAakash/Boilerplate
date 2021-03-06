package com.aliakberaakash.boilerplate.core.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.aliakberaakash.boilerplate.utils.BaseViewModelFactory
import java.lang.reflect.ParameterizedType

/**
 * This class is a boilerplate for setting up a Fragment
 * All Fragments in this project should extend this class
 * @author Ali Akber
 */
abstract class BaseFragment<ViewModel: BaseViewModel, Binding: ViewDataBinding> : Fragment(){

    lateinit var viewModel: ViewModel
    lateinit var binding: Binding

    abstract fun getLayoutId(): Int

    abstract fun setVariables(binding: Binding)

    abstract fun getViewModelFactory() : BaseViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, getViewModelFactory()).get(getViewModelClass())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        binding.lifecycleOwner = this
        setVariables(binding)
        lifecycle.addObserver(viewModel)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
    }

    private fun getViewModelClass(): Class<ViewModel> {
        val type =
            (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]   // index of 0 means first argument of Base class param
        return type as Class<ViewModel>
    }

    fun makeShortToast(message : String) = Toast.makeText(context, message, Toast.LENGTH_SHORT).show()


}