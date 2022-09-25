package com.akilincarslan.baseapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.akilincarslan.baseapp.R
import com.akilincarslan.baseapp.databinding.ActivityMainBinding
import com.akilincarslan.baseapp.utils.BaseInjectionActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseInjectionActivity<ActivityMainBinding,MainViewModel>() {

    override fun getLayoutRes(): Int = R.layout.activity_main
    override fun getViewModelClass(): Class<MainViewModel>  = MainViewModel::class.java

    private lateinit var navController :NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
        initBinding()
    }

    private fun initBinding() {
        binding.bottomNavView.setOnItemSelectedListener {
            navController.navigate(it.itemId)
            return@setOnItemSelectedListener true
        }
    }

}