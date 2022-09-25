package com.akilincarslan.baseapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akilincarslan.baseapp.network.responses.ProfileResponse
import com.akilincarslan.baseapp.repos.ProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val profileRepository: ProfileRepository
) : ViewModel() {

    private val _profileResult =MutableLiveData<ProfileResponse>()
    val profileResult :LiveData<ProfileResponse> = _profileResult

    fun fetchProfileInfo() {
        viewModelScope.launch {
            val result = profileRepository.fetchProfileInfo()
            _profileResult.value = result
        }
    }
}