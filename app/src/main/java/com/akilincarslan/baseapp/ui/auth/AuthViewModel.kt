package com.akilincarslan.baseapp.ui.auth

import androidx.lifecycle.ViewModel
import com.akilincarslan.baseapp.repos.auth.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val authRepository: AuthRepository) :ViewModel() {
}