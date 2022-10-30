package com.akilincarslan.baseapp.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseInjectionFragment<DB: ViewDataBinding, VM: ViewModel> :BaseFragment() {

    protected lateinit var binding: DB
    protected lateinit var viewModel: VM
    lateinit var TAG :String
    @LayoutRes
    protected abstract fun getLayoutRes():Int

    protected abstract fun getViewModelClass() :Class<VM>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[getViewModelClass()]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,getLayoutRes(),container,false)
        TAG = tag.toString()
        return binding.root
    }
}