package com.akilincarslan.baseapp.ui.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.akilincarslan.baseapp.R
import com.akilincarslan.baseapp.databinding.ActivityOnboardingBinding
import com.akilincarslan.baseapp.models.Onboard
import com.akilincarslan.baseapp.utils.BaseInjectionActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingActivity : BaseInjectionActivity<ActivityOnboardingBinding,OnboardingViewModel>() {
    override fun getLayoutRes(): Int = R.layout.activity_onboarding

    override fun getViewModelClass(): Class<OnboardingViewModel> = OnboardingViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        initBinding()
        initObservers()
        viewModel.fetchOnboardList()
    }

    private fun initBinding(){
        val adapter = OnboardingAdapter()
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