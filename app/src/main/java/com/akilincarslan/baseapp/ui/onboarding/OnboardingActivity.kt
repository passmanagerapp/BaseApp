package com.akilincarslan.baseapp.ui.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2
import com.akilincarslan.baseapp.R
import com.akilincarslan.baseapp.constants.LocalConstant
import com.akilincarslan.baseapp.databinding.ActivityOnboardingBinding
import com.akilincarslan.baseapp.models.Onboard
import com.akilincarslan.baseapp.repos.OnboardRepositoryImpl
import com.akilincarslan.baseapp.ui.auth.AuthActivity
import com.akilincarslan.baseapp.ui.main.MainActivity
import com.akilincarslan.baseapp.utils.BaseInjectionActivity
import com.akilincarslan.baseapp.utils.extension.showToast
import com.akilincarslan.baseapp.utils.extension.startActivity
import com.akilincarslan.baseapp.utils.helpers.LocalHelper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingActivity : BaseInjectionActivity<ActivityOnboardingBinding,OnboardingViewModel>() {
    override fun getLayoutRes(): Int = R.layout.activity_onboarding

    override fun getViewModelClass(): Class<OnboardingViewModel> = OnboardingViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        checkAndNavigateToAuth()
        super.onCreate(savedInstanceState)
        initBinding()
        initObservers()
        viewModel.fetchOnboardList()
    }

    private fun checkAndNavigateToAuth() {
        if (localHelper.getPrefBoolean(LocalConstant.IS_ONBOARD_COMPLETED,false)) {
            startActivity(AuthActivity::class.java)
            finish()
        }
    }

    private fun initBinding() = with(binding){
        viewPager.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                buttonGetStarted.isEnabled = position == 2
                buttonGetStarted.animate().alpha(if (position ==2) 1f else 0f)
            }
        })
        buttonGetStarted.setOnClickListener {
            localHelper.putPrefBoolean(LocalConstant.IS_ONBOARD_COMPLETED,true)
            startActivity(AuthActivity::class.java)
            finish()
        }
    }

    private fun initObservers() {
        viewModel.onboardListResult.observe(this) {
            initOnboardAdapter(it)
        }
    }

    private fun initOnboardAdapter(list:List<Onboard>) {
        val adapter = OnboardingAdapter()
        adapter.onboardList = list
        binding.viewPager.adapter = adapter
        binding.dotsIndicator.attachTo(binding.viewPager)
    }
}