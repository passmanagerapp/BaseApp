package com.akilincarslan.baseapp.ui.home

import android.os.Bundle
import android.view.View
import com.akilincarslan.baseapp.R
import com.akilincarslan.baseapp.databinding.FragmentHomeBinding
import com.akilincarslan.baseapp.ui.main.MainViewModel
import com.akilincarslan.baseapp.utils.BaseInjectionFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseInjectionFragment<FragmentHomeBinding,HomeViewModel>() {

    override fun getLayoutRes(): Int = R.layout.fragment_home
    override fun getViewModelClass(): Class<HomeViewModel> = HomeViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}