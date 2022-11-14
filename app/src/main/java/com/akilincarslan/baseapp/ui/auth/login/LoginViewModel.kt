package com.akilincarslan.baseapp.ui.auth.login

import androidx.lifecycle.ViewModel
import com.akilincarslan.baseapp.repos.auth.AuthRepository
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {
}