package com.akilincarslan.baseapp.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.navigateUp
import com.akilincarslan.baseapp.R
import com.akilincarslan.baseapp.databinding.ActivityAuthBinding
import com.akilincarslan.baseapp.utils.BaseInjectionActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : BaseInjectionActivity<ActivityAuthBinding,AuthViewModel>() {
    override fun getLayoutRes(): Int = R.layout.activity_auth
    override fun getViewModelClass(): Class<AuthViewModel> = AuthViewModel::class.java

    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}