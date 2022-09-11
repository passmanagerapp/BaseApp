package com.akilincarslan.baseapp.ui.setting

import android.os.Bundle
import android.view.View
import com.akilincarslan.baseapp.R
import com.akilincarslan.baseapp.databinding.FragmentSettingBinding
import com.akilincarslan.baseapp.ui.main.MainViewModel
import com.akilincarslan.baseapp.utils.BaseInjectionFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingFragment :BaseInjectionFragment<FragmentSettingBinding,MainViewModel>() {

    override fun getLayoutRes(): Int = R.layout.fragment_setting
    override fun getViewModelClass(): Class<MainViewModel> = MainViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}