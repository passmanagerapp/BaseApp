package com.akilincarslan.baseapp.utils

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseInjectionActivity<DB: ViewDataBinding, VM: ViewModel> :BaseActivity() {
    protected lateinit var  binding: DB
    protected lateinit var  viewModel: VM

    @LayoutRes
    protected abstract fun getLayoutRes() :Int

    protected abstract fun getViewModelClass() :Class<VM>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,getLayoutRes())
        viewModel = ViewModelProvider(this)[getViewModelClass()]
    }

}