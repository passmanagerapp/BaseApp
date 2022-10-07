package com.akilincarslan.baseapp.ui.onboarding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akilincarslan.baseapp.models.Onboard
import com.akilincarslan.baseapp.repos.OnboardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val repository: OnboardRepository
) :ViewModel() {
    val onboardListResult = MutableLiveData<List<Onboard>>()


    fun fetchOnboardList() {
        viewModelScope.launch {
            onboardListResult.value = repository.fetchOnboardList()
        }
    }
}