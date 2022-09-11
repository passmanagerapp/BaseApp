package com.akilincarslan.baseapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.akilincarslan.baseapp.R
import com.akilincarslan.baseapp.databinding.ActivityMainBinding
import com.akilincarslan.baseapp.utils.BaseInjectionActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseInjectionActivity<ActivityMainBinding,MainViewModel>() {

    override fun getLayoutRes(): Int = R.layout.activity_main

    override fun getViewModelClass(): Class<MainViewModel>  = MainViewModel::class.java

}