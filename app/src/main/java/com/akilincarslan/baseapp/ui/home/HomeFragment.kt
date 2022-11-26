package com.akilincarslan.baseapp.ui.home

import android.os.Bundle
import android.view.View
import com.akilincarslan.baseapp.R
import com.akilincarslan.baseapp.databinding.FragmentHomeBinding
import com.akilincarslan.baseapp.enums.Status
import com.akilincarslan.baseapp.models.Quote
import com.akilincarslan.baseapp.ui.home.adapter.DayOfQuotesAdapter
import com.akilincarslan.baseapp.ui.home.adapter.PeriodicAdapter
import com.akilincarslan.baseapp.ui.home.adapter.TopQuotesAdapter
import com.akilincarslan.baseapp.ui.main.MainViewModel
import com.akilincarslan.baseapp.ui.onboarding.OnboardingAdapter
import com.akilincarslan.baseapp.utils.BaseInjectionFragment
import com.akilincarslan.baseapp.utils.DialogUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseInjectionFragment<FragmentHomeBinding,HomeViewModel>() {

    override fun getLayoutRes(): Int = R.layout.fragment_home
    override fun getViewModelClass(): Class<HomeViewModel> = HomeViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBinding()
        initObservers()
    }

    private fun initBinding() = with(binding) {

    }

    private fun initObservers() {
        viewModel.topQuotesResult.observe(viewLifecycleOwner) {
            when(it.status) {
                Status.SUCCESS -> {
                    val adapter = TopQuotesAdapter()
                    adapter.topQuoteList = it.data ?: emptyList()
                    binding.rvTopQuotes.adapter = adapter
                    hideProgressDialog()
                }
                Status.LOADING -> showProgressDialog()
                Status.ERROR -> hideProgressDialog()
            }
        }
        viewModel.dayOfQuotesResult.observe(viewLifecycleOwner) {
            when(it.status) {
                Status.SUCCESS -> {
                    val adapter = DayOfQuotesAdapter()
                    adapter.dayOfQuotesList = it.data ?: emptyList()
                    binding.rvDayOfQuotes.adapter = adapter
                    hideProgressDialog()
                }
                Status.LOADING -> showProgressDialog()
                Status.ERROR -> hideProgressDialog()
            }
        }
        viewModel.periodicResult.observe(viewLifecycleOwner) {
            when(it.status) {
                Status.SUCCESS -> {
                    val adapter = PeriodicAdapter()
                    adapter.periodList = it.data ?: emptyList()
                    binding.viewPager.adapter = adapter
                    binding.dotsIndicator.attachTo(binding.viewPager)
                    hideProgressDialog()
                }
                Status.LOADING -> showProgressDialog()
                Status.ERROR -> hideProgressDialog()
            }
        }
    }
}